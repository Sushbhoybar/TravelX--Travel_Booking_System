import "../../styles/admin.css";
import Navbar from "../../components/Navbar";

function BusDetails() {
  return (
    <>
      <Navbar />

      <div className="container py-5">

        <h2 className="text-center text-primary fw-bold mb-5">
          🚌 Bus Details
        </h2>

        <div className="card shadow-lg border-0 p-4">

          <div className="row">

            <div className="col-md-5">

              <img
                src="https://images.unsplash.com/photo-1544620347-c4fd4a3d5957"
                alt="Bus"
                className="img-fluid rounded"
              />

            </div>

            <div className="col-md-7">

              <h3 className="text-primary">
                Ashoka Travels
              </h3>

              <hr />

              <p>
                <strong>Agent Name:</strong> Kiran Jagtap
              </p>

              <p>
                <strong>Number Plate:</strong> MH10AB5455
              </p>

              <p>
                <strong>Bus Type:</strong> AC Sleeper
              </p>

              <p>
                <strong>Total Seats:</strong> 40
              </p>

              <p>
                <strong>Route:</strong> Pune - Sangli
              </p>

              <p>
                <strong>Status:</strong>
                <span className="badge bg-warning text-dark ms-2">
                  Pending
                </span>
              </p>

            </div>

          </div>

          <hr />

          <div className="text-center mt-3">

            <button className="btn btn-success me-3 px-4">
              Approve
            </button>

            <button className="btn btn-danger px-4">
              Reject
            </button>

          </div>

        </div>

      </div>
    </>
  );
}

export default BusDetails;