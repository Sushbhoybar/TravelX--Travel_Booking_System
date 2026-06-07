import "../../styles/customer.css";
import { useNavigate } from "react-router-dom";

function Dashboard() {
  const navigate = useNavigate();

  return (
    <div className="travelx-dashboard">

      {}

      <nav className="navbar navbar-expand-lg navbar-dark bg-primary shadow">
        <div className="container">

          <span className="navbar-brand fw-bold">
            🚌 TravelX Booking System
          </span>

          <button
            className="btn btn-light"
            onClick={() => navigate("/")}
          >
            Logout
          </button>

        </div>
      </nav>

      {}

      <div className="container py-5">

        {}

        <div className="welcome-card mb-4">

          <h2 className="fw-bold">
            Welcome, Passenger ! 👋
          </h2>

          <p className="text-muted mb-0">
            Plan your journey and manage your bookings easily.
          </p>

        </div>

        {}

        <div
          className="search-card mb-4"
          onClick={() => navigate("/search-bus")}
        >
          <div>
            <h4>🔍 Search Buses</h4>
            <p className="mb-0">
              Find buses, compare prices and book tickets.
            </p>
          </div>

          <h3>➜</h3>
        </div>

        {}

        <div className="row g-4">

          <div className="col-md-4">

            <div className="feature-card">

              <h2>🎫</h2>

              <h5>My Bookings</h5>

              <p>
                View all your bookings and journey details.
              </p>

            </div>

          </div>

          <div className="col-md-4">

            <div className="feature-card">

              <h2>👤</h2>

              <h5>Profile</h5>

              <p>
                Update personal information.
              </p>

            </div>

          </div>

          <div className="col-md-4">

            <div className="feature-card">

              <h2>🎧</h2>

              <h5>Help & Support</h5>

              <p>
                Contact customer support.
              </p>

            </div>

          </div>

        </div>

        {}

        <div className="upcoming-card mt-5">

          <h4 className="mb-4">
            Upcoming Journey
          </h4>

          <div className="row align-items-center">

            <div className="col-md-8">

              <h5>🚌 Ashoka Travels</h5>

              <p className="mb-1">
                Pune ➜ Mumbai
              </p>

              <small>
                20 April 2026 | 10:00 AM
              </small>

            </div>

            <div className="col-md-4 text-end">

              <span className="badge bg-success fs-6">
                Confirmed
              </span>

            </div>

          </div>

        </div>

      </div>

    </div>
  );
}

export default Dashboard;