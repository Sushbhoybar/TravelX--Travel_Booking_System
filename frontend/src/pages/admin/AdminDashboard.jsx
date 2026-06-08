import "../../styles/admin.css";
import Navbar from "../../components/Navbar";
import { useNavigate } from "react-router-dom";

function AdminDashboard() {
  const navigate = useNavigate();

  return (
    <>
      <Navbar />

      <div className="dashboard-container">
        <div className="container py-5">

          <h1 className="text-center mb-5 dashboard-title">
            Admin Dashboard
          </h1>

          <div className="row g-4">

            <div className="col-md-6">
              <div
                className="dashboard-card"
                onClick={() => navigate("/users")}
              >
                <h3>👥 Manage Users</h3>
                <p>View, block and delete users.</p>
              </div>
            </div>

            <div className="col-md-6">
              <div
                className="dashboard-card"
                onClick={() => navigate("/buses")}
              >
                <h3>🚌 Approve Buses</h3>
                <p>Approve or reject bus requests.</p>
              </div>
            </div>

            <div className="col-md-6">
              <div
                className="dashboard-card"
                onClick={() => navigate("/feedback")}
              >
                <h3>⭐ View Feedback</h3>
                <p>Check passenger feedback.</p>
              </div>
            </div>

            <div className="col-md-6">
              <div
                className="dashboard-card"
                onClick={() => navigate("/admin-login")}
              >
                <h3>🚪 Logout</h3>
                <p>Exit admin panel.</p>
              </div>
            </div>

          </div>

        </div>
      </div>
    </>
  );
}

export default AdminDashboard;