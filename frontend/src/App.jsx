import { Routes, Route } from 'react-router-dom';

// import Login from './pages/Login';
import ChooseRegister from './pages/ChooseRegister';
import AgentRegister from "./pages/AgentRegister";
import AgentDashboard from "./pages/AgentDashboard";
import AddBus from "./pages/AddBus";
import ManageTrips from "./pages/ManageTrips";
import ViewBookings from "./pages/ViewBookings";
import PassengerList from "./pages/PassengerList";
import BusStatus from "./pages/BusStatus";

function App() {
  return (
    <Routes>
      {/* <Route path="/" element={<Login />} /> */}
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