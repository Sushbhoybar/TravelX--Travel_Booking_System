import users from "../../data/users";
import "../../styles/admin.css";
import Navbar from "../../components/Navbar";

function ManageUsers() {
  return (
    <>
      <Navbar />

      <div className="container py-5">

        <h2 className="text-center mb-4 page-heading">
          👥 Manage Users
        </h2>

        <div className="table-responsive">

          <table className="table table-bordered table-hover shadow bg-white">

            <thead className="table-primary">
              <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Action</th>
              </tr>
            </thead>

            <tbody>

              {users.map((user) => (
                <tr key={user.id}>

                  <td>{user.name}</td>
                  <td>{user.email}</td>
                  <td>{user.phone}</td>

                  <td>

                    <button className="btn btn-warning btn-sm me-2">
                      Block
                    </button>

                    <button className="btn btn-danger btn-sm">
                      Delete
                    </button>

                  </td>

                </tr>
              ))}

            </tbody>

          </table>

        </div>

      </div>
    </>
  );
}

export default ManageUsers;