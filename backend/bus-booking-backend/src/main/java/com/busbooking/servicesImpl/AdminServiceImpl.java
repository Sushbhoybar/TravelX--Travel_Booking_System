//package com.busbooking.servicesImpl;
//
//import org.springframework.stereotype.Service;
//
//import com.busbooking.custom_exception.InvalidCredentialsException;
//import com.busbooking.dtos.AdminLoginRequest;
//import com.busbooking.dtos.AdminLoginResponse;
//import com.busbooking.dtos.ApiResponse;
//import com.busbooking.dtos.BusDetailsResponse;
//import com.busbooking.entities.User;
//import com.busbooking.entities.UserRole;
//import com.busbooking.repository.UserRepository;
//import com.busbooking.services.AdminService;
//import java.util.List;
//import java.util.stream.Collectors;
//import com.busbooking.dtos.UserResponse;
//import com.busbooking.entities.User;
//import lombok.RequiredArgsConstructor;
//import com.busbooking.entities.Bus;
//import com.busbooking.entities.BusStatus;
//import com.busbooking.repository.BusRepository;
//import com.busbooking.dtos.BusResponse;
//import com.busbooking.dtos.FeedbackResponse;
//import com.busbooking.repository.FeedbackRepository;
//
//
//
//@Service
//@RequiredArgsConstructor
//public class AdminServiceImpl implements AdminService {
//
//    private final UserRepository userRepository;
//    
//    private final BusRepository busRepository;
//    
//    private final FeedbackRepository feedbackRepository;
//
//    @Override
//    public AdminLoginResponse login(AdminLoginRequest request) {
//
//        User user = userRepository.findByEmail(request.getEmail())
//                .orElseThrow(() ->
//                        new InvalidCredentialsException("Invalid Email or Password"));
//
//        // Plain text password check
//        if (!user.getPassword().equals(request.getPassword())) {
//            throw new InvalidCredentialsException("Invalid Email or Password");
//        }
//
//        // Allow only admin
//        if (user.getRole() != UserRole.ADMIN) {
//            throw new InvalidCredentialsException("Only Admin can login.");
//        }
//
//        String fullName = user.getFirstName() + " "
//                + (user.getMiddleName() == null ? "" : user.getMiddleName() + " ")
//                + user.getLastName();
//
//        return new AdminLoginResponse(
//                user.getUserId(),
//                fullName.trim(),
//                user.getEmail(),
//                "Login Successful"
//        );
//    }
//    
//    @Override
//    public List<UserResponse> getAllUsers() {
//
//        return userRepository.findAll()
//                .stream()
//                .map(user -> new UserResponse(
//                        user.getUserId(),
//                        user.getFirstName() + " " + user.getLastName(),
//                        user.getEmail(),
//                        user.getPhone(),
//                        user.getRole().name(),
//                        user.getIsActive()
//                ))
//                .collect(Collectors.toList());
//    }
//    
//    
//    @Override
//    public ApiResponse blockUser(Long userId) {
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setIsActive(false);
//
//        userRepository.save(user);
//
//        return new ApiResponse("User Blocked Successfully");
//    }
//
//    @Override
//    public ApiResponse unblockUser(Long userId) {
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setIsActive(true);
//
//        userRepository.save(user);
//
//        return new ApiResponse("User Unblocked Successfully");
//    }
//    
//    @Override
//    public ApiResponse deleteUser(Long userId) {
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        userRepository.delete(user);
//
//        return new ApiResponse("User Deleted Successfully");
//    }
//    
//    @Override
//    public List<BusResponse> getAllBuses() {
//
//        return busRepository.findAll()
//                .stream()
//                .map(bus -> new BusResponse(
//                        bus.getBusId(),
//                        bus.getBusName(),
//                        bus.getAgent().getFirstName() + " " + bus.getAgent().getLastName(),
//                        bus.getNumberPlate(),
//                        bus.getStatus()
//                ))
//                .toList();
//
//    }
//    
//    @Override
//    public BusDetailsResponse getBusById(Long busId) {
//
//        Bus bus = busRepository.findById(busId)
//                .orElseThrow(() -> new RuntimeException("Bus not found"));
//
//        return new BusDetailsResponse(
//                bus.getBusId(),
//                bus.getBusName(),
//                bus.getAgent().getFirstName() + " " + bus.getAgent().getLastName(),
//                bus.getNumberPlate(),
//                bus.getBusType(),
//                bus.getTotalSeats(),
//                bus.getRoute(),
//                bus.getImageUrl(),
//                bus.getStatus()
//        );
//    }
//    
//    @Override
//    public ApiResponse approveBus(Long busId) {
//
//        Bus bus = busRepository.findById(busId)
//                .orElseThrow(() -> new RuntimeException("Bus not found"));
//
//        bus.setStatus(BusStatus.APPROVED);
//
//        busRepository.save(bus);
//
//        return new ApiResponse("Bus Approved Successfully");
//    }
//    
//    @Override
//    public ApiResponse rejectBus(Long busId) {
//
//        Bus bus = busRepository.findById(busId)
//                .orElseThrow(() -> new RuntimeException("Bus not found"));
//
//        bus.setStatus(BusStatus.REJECTED);
//
//        busRepository.save(bus);
//
//        return new ApiResponse("Bus Rejected Successfully");
//    }
//    
//    @Override
//    public List<FeedbackResponse> getAllFeedback() {
//
//        return feedbackRepository.findAll()
//                .stream()
//                .map(feedback -> new FeedbackResponse(
//                        feedback.getFeedbackId(),
//                        feedback.getName(),
//                        feedback.getRating(),
//                        feedback.getReview(),
//                        feedback.getDate()
//                ))
//                .collect(Collectors.toList());
//    }
//}