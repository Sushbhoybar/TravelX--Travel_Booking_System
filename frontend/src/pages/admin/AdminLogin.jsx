import "../../styles/admin.css";
import { useNavigate } from "react-router-dom";

function AdminLogin() {
  const navigate = useNavigate();
  return (
    <div className="login-container">
      <div className="login-card">

        <div className="login-icon">
          🔐
        </div>

        <h2 className="login-title">
          TravelX - Travel Booking System
        </h2>

        <p className="login-subtitle">
          Admin Portal Login
        </p>

        <div className="mb-3">
          <label className="form-label">
            Email Address
          </label>

          <input
            type="email"
            className="form-control"
            placeholder="Enter Email"
          />
        </div>

        <div className="mb-4">
          <label className="form-label">
            Password
          </label>

          <input
            type="password"
            className="form-control"
            placeholder="Enter Password"
          />
        </div>

        <button
  className="btn login-btn w-100"
  onClick={() => navigate("/dashboard")}
  >
     Login
  </button>
    
      </div>
    </div>
  );
}

export default AdminLogin;