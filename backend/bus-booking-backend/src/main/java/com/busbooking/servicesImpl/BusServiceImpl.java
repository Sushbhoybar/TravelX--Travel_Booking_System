package com.busbooking.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.busbooking.custom_exception.DuplicateResourceException;
import com.busbooking.custom_exception.ResourceNotFoundException;
import com.busbooking.dtos.AddBusRequest;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.BusDetailsResponse;
import com.busbooking.dtos.BusResponse;
import com.busbooking.dtos.UpdateBusRequest;
import com.busbooking.entities.Bus;
import com.busbooking.entities.BusImage;
import com.busbooking.entities.BusStatus;
import com.busbooking.entities.DeckType;
import com.busbooking.entities.Seat;
import com.busbooking.entities.SeatType;
import com.busbooking.entities.User;
import com.busbooking.repository.BusImageRepository;
import com.busbooking.repository.BusRepository;
import com.busbooking.repository.SeatRepository;
import com.busbooking.repository.UserRepository;
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

        logger.info("Bus saved successfully with id {}",
                savedBus.getBusId());

        saveImages(
                savedBus,
                request.getBusImages());

        generateSeats(savedBus);

        logger.info("Bus registration completed.");

        return new ApiResponse(
                "Bus Added Successfully");
    }

    @Override
    @Transactional(readOnly = true)
    public List<BusResponse> getMyBuses(String email) {

        logger.info("Fetching buses for agent {}", email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Agent not found"));

        List<Bus> buses = busRepository.findByAgent(user);

        List<BusResponse> response = new ArrayList<>();

        for (Bus bus : buses) {

            response.add(

                    new BusResponse(

                            bus.getBusId(),

                            bus.getBusName(),

                            bus.getRegistrationNumber(),

                            bus.getBusType(),

                            bus.getTotalSeats(),

                            bus.getStatus()

                    )

            );

        }

        logger.info("{} buses found", response.size());

        return response;

    }

    @Override
    @Transactional(readOnly = true)
    public BusDetailsResponse getBusDetails(Long busId) {

        logger.info("Fetching bus details {}", busId);

        Bus bus = busRepository.findById(busId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bus Not Found"));

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
    public ApiResponse updateBus(Long busId,
            UpdateBusRequest request) {

        logger.info("Updating bus {}", busId);

        Bus bus = busRepository.findById(busId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bus Not Found"));

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
    public ApiResponse deleteBus(Long busId) {

        logger.info("Deleting bus {}", busId);

        Bus bus = busRepository.findById(busId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bus Not Found"));

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
    
    private void generateSeats(Bus bus) {

        logger.info("Generating seats...");

        List<Seat> seats = new ArrayList<>();

        for (int i = 1; i <= bus.getTotalSeats(); i++) {

            Seat seat = new Seat();

            seat.setBus(bus);

            seat.setSeatNumber("S" + i);

            seat.setDeck(DeckType.LOWER);

            seat.setSeatType(SeatType.SEATER);

            seat.setIsWindow(
                    i % 4 == 1 || i % 4 == 0);

            seats.add(seat);

        }

        seatRepository.saveAll(seats);

        logger.info("{} seats generated",
                seats.size());

    }
    
    
	
	
}
