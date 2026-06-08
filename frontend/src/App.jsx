import { Routes, Route } from 'react-router-dom';

import Login from './pages/customer/Login';
import Register from "./pages/customer/Register";
import Dashboard from "./pages/customer/Dashboard";
import SearchBus from "./pages/customer/SearchBus";

import ChooseRegister from './pages/agent/ChooseRegister';
import AgentRegister from "./pages/agent/AgentRegister";
import AgentDashboard from "./pages/agent/AgentDashboard";
import AddBus from "./pages/agent/AddBus";
import ManageTrips from "./pages/agent/ManageTrips";
import ViewBookings from "./pages/agent/ViewBookings";
import PassengerList from "./pages/agent/PassengerList";
import BusStatus from "./pages/agent/BusStatus";







function App() {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register/customer" element={<Register />}/>
      <Route path="/dashboard" element={<Dashboard />}/>
      <Route path="/search-bus" element={<SearchBus />}/>
      <Route path="/register" element={<ChooseRegister />} />
      <Route path="/register/agent" element={<AgentRegister />} />
      <Route path="/agent/dashboard" element={<AgentDashboard />} />
      <Route path="/agent/add-bus" element={<AddBus />} />
      <Route path="/agent/manage-routes" element={<ManageTrips />} />
      <Route path="/agent/view-bookings" element={<ViewBookings />} />
      <Route path="/agent/passengers/:tripId" element={<PassengerList />} />
      <Route path="/agent/bus-status" element={<BusStatus />} />
      
      



    </Routes>
  );
}

export default App;