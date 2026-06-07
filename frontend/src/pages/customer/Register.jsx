import "../../styles/customer.css";
import { Link, useNavigate } from "react-router-dom";

function Register() {
  const navigate = useNavigate();

  return (
    <div className="customer-bg">

      <div
        className="glass-card"
        style={{
          width: "550px",
          maxWidth: "95%"
        }}
      >

        <h2 className="text-center travelx-title mb-2">
          Create Account
        </h2>

        <p className="text-center text-muted mb-4">
          Join TravelX Booking System
        </p>

        <form>

          <div className="mb-3">
            <label className="form-label">
              Full Name
            </label>

            <input
              type="text"
              className="form-control"
              placeholder="Enter Full Name"
            />
          </div>

          <div className="mb-3">
            <label className="form-label">
              Email
            </label>

            <input
              type="email"
              className="form-control"
              placeholder="Enter Email"
            />
          </div>

          <div className="mb-3">
            <label className="form-label">
              Phone Number
            </label>

            <input
              type="tel"
              className="form-control"
              placeholder="Enter Phone Number"
            />
          </div>

          <div className="row">

            <div className="col-md-6 mb-3">

              <label className="form-label">
                Age
              </label>

              <input
                type="number"
                className="form-control"
                placeholder="Enter Age"
              />

            </div>

            <div className="col-md-6 mb-3">

              <label className="form-label">
                Gender
              </label>

              <select className="form-select">
                <option>Select Gender</option>
                <option>Male</option>
                <option>Female</option>
                <option>Other</option>
              </select>

            </div>

          </div>

          <div className="mb-3">

            <label className="form-label">
              Password
            </label>

            <input
              type="password"
              className="form-control"
              placeholder="Enter Password"
            />

          </div>

          <div className="mb-4">

            <label className="form-label">
              Confirm Password
            </label>

            <input
              type="password"
              className="form-control"
              placeholder="Confirm Password"
            />

          </div>

          <button
            type="button"
            className="btn travelx-btn w-100"
            onClick={() => {
            alert("Registration Successful!");
            navigate("/customer-login");
            }}
            >Register</button>

        </form>

        <div className="text-center mt-4">

          Already have an account?

          <Link
            to="/customer-login"
            className="ms-2"
          >
            Login
          </Link>

        </div>

      </div>

    </div>
  );
}

export default Register;