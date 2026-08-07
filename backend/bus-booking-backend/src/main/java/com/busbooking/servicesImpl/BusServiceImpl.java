package com.busbooking.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.busbooking.custom_exception.BusinessException;
import com.busbooking.custom_exception.DuplicateResourceException;
import com.busbooking.custom_exception.ResourceNotFoundException;
import com.busbooking.dtos.AddBusRequest;
import com.busbooking.dtos.AgentBusResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.BusDetailsResponse;
import com.busbooking.dtos.UpdateBusRequest;
import com.busbooking.entities.Bus;
import com.busbooking.entities.BusImage;
import com.busbooking.entities.BusStatus;
import com.busbooking.services.SeatGeneratorService;
import com.busbooking.entities.User;
import com.busbooking.repository.BusImageRepository;
import com.busbooking.repository.BusRepository;
import com.busbooking.repository.SeatRepository;
import com.busbooking.repository.UserRepository;
import com.busbooking.dtos.AgentBusDetailsResponse;
import com.busbooking.services.BusService;
import com.busbooking.services.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BusServiceImpl implements BusService {

    private static final Logger logger =
            LoggerFactory.getLogger(BusServiceImpl.class);

    private final BusRepository busRepository;

    private final UserRepository userRepository;

    private final SeatRepository seatRepository;

    private final BusImageRepository busImageRepository;

    private final FileStorageService fileStorageService;

    private final SeatGeneratorService seatGeneratorService;

    @Override
    public ApiResponse addBus(AddBusRequest request,
                              String email) {

        logger.info("Agent {} is adding new bus", email);

        if (busRepository.existsByRegistrationNumber(
                request.getRegistrationNumber())) {

            throw new DuplicateResourceException(
                    "Registration Number already exists");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Agent not found"));


        Bus bus = new Bus();

        bus.setBusName(request.getBusName());

        bus.setRegistrationNumber(
                request.getRegistrationNumber());

        bus.setBusType(request.getBusType());

        bus.setTotalSeats(request.getTotalSeats());

        bus.setAmenities(request.getAmenities());

        String insuranceDocument =
                fileStorageService.saveFile(
                        request.getInsuranceDocument(),
                        "documents/insurance");

        bus.setInsuranceDocument(
                insuranceDocument);


        String registrationPath =
                fileStorageService.saveFile(
                        request.getRegistrationCertificate(),
                        "documents/registration");

        bus.setRegistrationCertificate(registrationPath);
     
 
        String fitnessCertificate =
                fileStorageService.saveFile(
                        request.getFitnessCertificate(),
                        "documents/fitness");

        bus.setFitnessCertificate(
                fitnessCertificate);


  
        String permitDocument =
                fileStorageService.saveFile(
                        request.getPermitDocument(),
                        "documents/permit");

        bus.setPermitDocument(
                permitDocument);
   

    
        String pollutionCertificate =
                fileStorageService.saveFile(
                        request.getPollutionCertificate(),
                        "documents/pollution");

        bus.setPollutionCertificate(
                pollutionCertificate);
      

        bus.setStatus(BusStatus.PENDING);

        bus.setAgent(user);

        Bus savedBus = busRepository.save(bus);

        logger.info(
                "Bus saved successfully with id {}",
                savedBus.getBusId());

        saveImages(
                savedBus,
                request.getBusImages());

        seatGeneratorService.generateSeats(savedBus);

        logger.info("Bus registration completed.");

        return new ApiResponse(
                "Bus Added Successfully");
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgentBusResponse> getMyBuses(String email) {

        logger.info("Fetching agent buses for {}", email);

        User agent =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        List<Bus> buses =
                busRepository.findByAgentOrderByCreatedAtDesc(agent);

        List<AgentBusResponse> response =
                new ArrayList<>();

        for (Bus bus : buses) {

            AgentBusResponse dto =
                    new AgentBusResponse();

            dto.setBusId(
                    bus.getBusId());

            dto.setBusName(
                    bus.getBusName());

            dto.setRegistrationNumber(
                    bus.getRegistrationNumber());

            dto.setBusType(
                    bus.getBusType());

            dto.setTotalSeats(
                    bus.getTotalSeats());

            dto.setStatus(
                    bus.getStatus());

            dto.setAdminRemarks(
                    bus.getAdminRemarks());

            dto.setCanEdit(
                    bus.getStatus() ==
                    BusStatus.REJECTED);

            dto.setCanDelete(
                    bus.getStatus() !=
                    BusStatus.APPROVED);

            response.add(dto);

        }

        return response;

    }

    @Override
    @Transactional(readOnly = true)
    public BusDetailsResponse getBusDetails(
            Long busId,
            String email) {

        logger.info("Fetching bus details {}", busId);

        User agent =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        Bus bus =
                busRepository.findByBusIdAndAgent(
                        busId,
                        agent)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Bus not found"));

        BusDetailsResponse response = new BusDetailsResponse();

        response.setBusId(bus.getBusId());

        response.setBusName(bus.getBusName());

        response.setRegistrationNumber(bus.getRegistrationNumber());

        response.setBusType(bus.getBusType());

        response.setTotalSeats(bus.getTotalSeats());

        response.setAmenities(bus.getAmenities());

        response.setInsuranceDocument(bus.getInsuranceDocument());

        response.setRegistrationCertificate(
                bus.getRegistrationCertificate());

        response.setFitnessCertificate(
                bus.getFitnessCertificate());

        response.setPermitDocument(
                bus.getPermitDocument());

        response.setPollutionCertificate(
                bus.getPollutionCertificate());

        response.setStatus(bus.getStatus());

        List<String> imageUrls = new ArrayList<>();

        for (BusImage image : bus.getImages()) {

            imageUrls.add(image.getImageUrl());

        }

        response.setImageUrls(imageUrls);

        return response;

    }

    @Override
    public ApiResponse updateBus(
            Long busId,
            UpdateBusRequest request,
            String email) {

        logger.info("Updating bus {}", busId);

        User agent =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        Bus bus =
                busRepository.findByBusIdAndAgent(
                        busId,
                        agent)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Bus not found"));
        
        if (bus.getStatus() == BusStatus.PENDING) {

            throw new BusinessException(
                    "This bus is currently under admin review and cannot be edited.");

        }

        if (bus.getStatus() == BusStatus.APPROVED) {

            throw new BusinessException(
                    "Approved buses cannot be edited.");

        }

        bus.setBusName(request.getBusName());

        bus.setBusType(request.getBusType());

        bus.setTotalSeats(request.getTotalSeats());

        bus.setAmenities(request.getAmenities());

        if (request.getInsuranceDocument() != null
                && !request.getInsuranceDocument().isEmpty()) {

            String insurancePath =
                    fileStorageService.saveFile(
                            request.getInsuranceDocument(),
                            "documents/insurance");

            bus.setInsuranceDocument(insurancePath);
        }
        
        if (request.getRegistrationCertificate() != null
                && !request.getRegistrationCertificate().isEmpty()) {

            String registrationPath =
                    fileStorageService.saveFile(
                            request.getRegistrationCertificate(),
                            "documents/registration");

            bus.setRegistrationCertificate(registrationPath);
        }

        if (request.getFitnessCertificate() != null
                && !request.getFitnessCertificate().isEmpty()) {
	        String fitnessCertificate =
	                fileStorageService.saveFile(
	                        request.getFitnessCertificate(),
	                        "documents/fitness");
	
	        bus.setFitnessCertificate(
	                fitnessCertificate);
        }

        if (request.getPermitDocument() != null
                && !request.getPermitDocument().isEmpty()) {
	        String permitDocument =
	                fileStorageService.saveFile(
	                        request.getPermitDocument(),
	                        "documents/permit");
	
	        bus.setPermitDocument(
	                permitDocument);
        }

        if (request.getPollutionCertificate() != null
                && !request.getPollutionCertificate().isEmpty()) {
	        String pollutionCertificate =
	                fileStorageService.saveFile(
	                        request.getPollutionCertificate(),
	                        "documents/pollution");
	
	        bus.setPollutionCertificate(
	                pollutionCertificate);
        }
        
        if (bus.getStatus() == BusStatus.REJECTED) {

            bus.setStatus(
                    BusStatus.PENDING);

            bus.setAdminRemarks(null);

        }
        busRepository.save(bus);

        if (request.getBusImages() != null
                && !request.getBusImages().isEmpty()) {

            busImageRepository.deleteByBus(bus);

            saveImages(bus, request.getBusImages());
        }

        logger.info("Bus updated successfully");

        return new ApiResponse(
                "Bus Updated Successfully");

    }

    @Override
    public ApiResponse deleteBus(
            Long busId,
            String email) {

        logger.info("Deleting bus {}", busId);

        User agent =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        Bus bus =
                busRepository.findByBusIdAndAgent(
                        busId,
                        agent)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Bus not found"));
        
        if (bus.getStatus() == BusStatus.PENDING) {

            throw new BusinessException(
                    "This bus is currently under admin review and cannot be deleted.");

        }

        if (bus.getStatus() == BusStatus.APPROVED) {

            throw new BusinessException(
                    "Approved buses cannot be deleted.");

        }

        seatRepository.deleteByBus(bus);

        busImageRepository.deleteByBus(bus);

        busRepository.delete(bus);

        logger.info("Bus deleted");

        return new ApiResponse(
                "Bus Deleted Successfully");

    }
	
	//Helper
    private void saveImages(
            Bus bus,
            List<MultipartFile> busImages) {

        if (busImages == null || busImages.isEmpty()) {
            return;
        }

        for (MultipartFile file : busImages) {

            if (file.isEmpty()) {
                continue;
            }

            String imagePath =
                    fileStorageService.saveFile(
                            file,
                            "buses");

            BusImage image = new BusImage();

            image.setBus(bus);

            image.setImageUrl(imagePath);

            busImageRepository.save(image);
        }
    }
    
    

    @Override
    @Transactional(readOnly = true)
    public AgentBusDetailsResponse getBus(
            Long busId,
            String email) {

        logger.info(
                "Fetching bus {} for editing",
                busId);

        User agent =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        Bus bus =
                busRepository.findByBusIdAndAgent(
                        busId,
                        agent)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Bus not found"));

        AgentBusDetailsResponse dto =
                new AgentBusDetailsResponse();

        dto.setBusId(
                bus.getBusId());

        dto.setBusName(
                bus.getBusName());

        dto.setRegistrationNumber(
                bus.getRegistrationNumber());

        dto.setBusType(
                bus.getBusType());

        dto.setTotalSeats(
                bus.getTotalSeats());

        dto.setAmenities(
                bus.getAmenities());

        dto.setInsuranceDocument(
                bus.getInsuranceDocument());

        dto.setRegistrationCertificate(
                bus.getRegistrationCertificate());

        dto.setFitnessCertificate(
                bus.getFitnessCertificate());

        dto.setPermitDocument(
                bus.getPermitDocument());

        dto.setPollutionCertificate(
                bus.getPollutionCertificate());

        dto.setStatus(
                bus.getStatus());

        dto.setAdminRemarks(
                bus.getAdminRemarks());
        
        dto.setEditable(
                bus.getStatus() ==
                BusStatus.REJECTED);

        List<String> images =
                new ArrayList<>();

        for (BusImage image : bus.getImages()) {

            images.add(
                    image.getImageUrl());

        }

        dto.setImages(images);

        return dto;

    }
    
    
	
	
}
