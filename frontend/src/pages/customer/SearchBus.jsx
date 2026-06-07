import "../../styles/customer.css";
import { useNavigate } from "react-router-dom";

function SearchBus() {
  const navigate = useNavigate();

  return (
    <div className="travelx-dashboard">

      {}

      <nav className="navbar navbar-expand-lg navbar-dark bg-primary shadow">
        <div className="container">

          <span
            className="navbar-brand fw-bold"
            style={{ color: "#edecec" }}
          >
            🚌 TravelX Booking System
          </span>

         <button
         className="btn btn-outline-light"
        onClick={() => navigate("/")}
        >
        Logout
        </button>

        </div>
      </nav>

      <div className="container py-5">

        <div className="search-form-card">

          <h2 className="text-center mb-4">
            Search Your Journey
          </h2>

          <div className="row">

            <div className="col-md-4 mb-3">
              <label className="form-label">
                From
              </label>

              <input
                type="text"
                className="form-control"
                placeholder="Enter Source City"
              />
            </div>

            <div className="col-md-4 mb-3">
              <label className="form-label">
                To
              </label>

              <input
                type="text"
                className="form-control"
                placeholder="Enter Destination"
              />
            </div>

            <div className="col-md-4 mb-3">
              <label className="form-label">
                Journey Date
              </label>

              <input
                type="date"
                className="form-control"
              />
            </div>

          </div>

          <div className="text-center mt-4">

            <button
              className="btn btn-lg search-btn"
              onClick={() => navigate("/bus-list")}
            >
              🔍 Search Buses
            </button>

          </div>

        </div>

      </div>

    </div>
  );
}

export default SearchBus;