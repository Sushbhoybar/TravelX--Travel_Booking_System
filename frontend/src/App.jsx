import { Routes, Route } from 'react-router-dom';

import Login from './pages/customer/Login';
import Register from "./pages/customer/Register";
import Dashboard from "./pages/customer/Dashboard";
import SearchBus from "./pages/customer/SearchBus";
import BusList from "./pages/customer/BusList";
import BusDetails1 from "./pages/customer/BusDetails";
import SeatSelection from "./pages/customer/SeatSelection";
import PassengerDetails from "./pages/customer/PassengerDetails";
import Payment from "./pages/customer/Payment";
import BookingHistory from "./pages/customer/BookingHistory";
import Profile from "./pages/customer/Profile";
import Feedback from "./pages/customer/Feedback";
import Support from "./pages/customer/Support";
import ViewBookingDetails from "./pages/customer/ViewBookingDetails";


import ChooseRegister from './pages/agent/ChooseRegister';
import AgentRegister from "./pages/agent/AgentRegister";
import AgentDashboard from "./pages/agent/AgentDashboard";
import AddBus from "./pages/agent/AddBus";
import ManageTrips from "./pages/agent/ManageTrips";
import ViewBookings from "./pages/agent/ViewBookings";
import PassengerList from "./pages/agent/PassengerList";
import BusStatus from "./pages/agent/BusStatus";

import AdminLogin from "./pages/admin/AdminLogin";
import AdminDashboard from "./pages/admin/AdminDashboard";
import ManageUsers from "./pages/admin/ManageUsers";
import ApproveBuses from "./pages/admin/ApproveBuses";
import BusDetails from "./pages/admin/BusDetails";
import ViewFeedback from "./pages/admin/ViewFeedback";



function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register/customer" element={<Register />} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/search-bus" element={<SearchBus />} />
      <Route path="/bus-list" element={<BusList />} />
      <Route path="/bus-details/:id" element={<BusDetails1 />} />
      <Route path="/seat-selection/:id" element={<SeatSelection />} />
      <Route path="/passenger-details" element={<PassengerDetails />} />
      <Route path="/booking-history" element={<BookingHistory />} />
      <Route path="/profile" element={<Profile />} />
      <Route path="/feedback" element={<Feedback />} />
      <Route path="/support" element={<Support />} />
      <Route path="/booking-details/:id" element={<ViewBookingDetails />} />

      <Route path="/register" element={<ChooseRegister />} />
      <Route path="/register/agent" element={<AgentRegister />} />
      <Route path="/agent/dashboard" element={<AgentDashboard />} />
      <Route path="/agent/add-bus" element={<AddBus />} />
      <Route path="/agent/manage-routes" element={<ManageTrips />} />
      <Route path="/agent/view-bookings" element={<ViewBookings />} />
      <Route path="/agent/passengers/:tripId" element={<PassengerList />} />
      <Route path="/agent/bus-status" element={<BusStatus />} />
      <Route path="/payment" element={<Payment />} />

      <Route path="/admin-login" element={<AdminLogin />} />

      <Route path="/admin-dashboard" element={<AdminDashboard />} />

      <Route path="/users" element={<ManageUsers />} />

      <Route path="/buses" element={<ApproveBuses />} />

      <Route path="/bus-details" element={<BusDetails />} />

      <Route path="/feedback" element={<ViewFeedback />} />


    </Routes>
  );
}

export default App;