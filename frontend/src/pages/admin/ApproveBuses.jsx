import buses from "../../data/buses";
import "../../styles/admin.css";
import Navbar from "../../components/Navbar";
import { useNavigate } from "react-router-dom";

function ApproveBuses() {
  const navigate = useNavigate();

  return (
    <>
      <Navbar />

      <div className="container py-5">

        <h2 className="text-center mb-5 text-primary fw-bold">
          🚌 Bus Approval Requests
        </h2>

        <div className="row">

          {buses.map((bus) => (
            <div className="col-md-4 mb-4" key={bus.id}>

              <div className="bus-card">

                <h4>{bus.busName}</h4>

                <p>
                  <strong>Agent:</strong> {bus.agentName}
                </p>

                <p>
                  <strong>Number Plate:</strong> {bus.numberPlate}
                </p>

                <span className="badge bg-warning text-dark mb-3">
                  {bus.status}
                </span>

                <div>
                  <button
                    className="btn btn-primary w-100"
                    onClick={() => navigate("/bus-details")}
                  >
                    View Details
                  </button>
                </div>

              </div>

            </div>
          ))}

        </div>

      </div>
    </>
  );
}

export default ApproveBuses;