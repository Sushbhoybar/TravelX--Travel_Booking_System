import "../../styles/customer.css";
import { Link, useNavigate } from "react-router-dom";

function Login() {
  const navigate = useNavigate();

  return (
    <div className="customer-bg">

      <div
        className="glass-card"
        style={{ width: "420px" }}
      >

        <h2
          className="text-center travelx-title mb-3"
        >
          TravelX Login
        </h2>

        <p className="text-center text-muted">
          Welcome back!
        </p>

        <div className="mb-3">
          <input
            type="email"
            className="form-control"
            placeholder="Email"
          />
        </div>

        <div className="mb-3">
          <input
            type="password"
            className="form-control"
            placeholder="Password"
          />
        </div>

        <button
          className="btn travelx-btn w-100"
          onClick={() =>
            navigate("/customer-dashboard")
          }
        >
          Sign In
        </button>

        <div className="text-center mt-3">

          New User?

          <Link to="/customer-register">
            Register
          </Link>

        </div>

      </div>

    </div>
  );
}

export default Login;