import React, { useState } from "react";

import {
  FaUser,
  FaEnvelope,
  FaPhone,
  FaVenusMars,
  FaEdit,
  FaTimes,
  FaSave,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function Profile() {
  const [showEditModal, setShowEditModal] =
    useState(false);

  const [profile, setProfile] = useState({
    name: "Sushil Bhoybar",
    email: "sushil@gmail.com",
    phone: "9876543210",
    gender: "Male",
  });

  const [formData, setFormData] =
    useState(profile);

  const recentBookings = [
    {
      id: "TX101",
      route: "Pune → Latur",
      date: "20-Apr-2026",
      status: "Confirmed",
    },
    {
      id: "TX102",
      route: "Pune → Mumbai",
      date: "15-Apr-2026",
      status: "Completed",
    },
    {
      id: "TX103",
      route: "Latur → Pune",
      date: "10-Apr-2026",
      status: "Cancelled",
    },
  ];

  const handleSave = () => {
    setProfile(formData);
    setShowEditModal(false);

    alert("Profile Updated Successfully!");
  };

  const getStatusStyle = (status) => {
    switch (status) {
      case "Confirmed":
        return "bg-green-100 text-green-700";

      case "Completed":
        return "bg-blue-100 text-blue-700";

      case "Cancelled":
        return "bg-red-100 text-red-700";

      default:
        return "bg-slate-100 text-slate-700";
    }
  };

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-8">

        <div className="max-w-5xl mx-auto">

          {/* Profile Section */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md overflow-hidden">

            <div className="bg-blue-600 px-6 py-5 flex justify-between items-center">

              <h1 className="text-2xl font-black text-white">
                My Profile
              </h1>

              <button
                onClick={() =>
                  setShowEditModal(true)
                }
                className="
                  bg-white
                  text-blue-600
                  px-4
                  py-2
                  rounded-xl
                  font-semibold
                  flex
                  items-center
                  gap-2
                  hover:bg-slate-100
                "
              >
                <FaEdit />
                Edit Profile
              </button>

            </div>

            <div className="p-6">

              <table className="w-full border-collapse">

                <tbody>

                  <tr>

                    <td className="border border-slate-300 px-5 py-4 font-semibold bg-slate-50 w-52">
                      <div className="flex items-center gap-2">
                        <FaUser />
                        Full Name
                      </div>
                    </td>

                    <td className="border border-slate-300 px-5 py-4">
                      {profile.name}
                    </td>

                  </tr>

                  <tr>

                    <td className="border border-slate-300 px-5 py-4 font-semibold bg-slate-50">
                      <div className="flex items-center gap-2">
                        <FaEnvelope />
                        Email Address
                      </div>
                    </td>

                    <td className="border border-slate-300 px-5 py-4">
                      {profile.email}
                    </td>

                  </tr>

                  <tr>

                    <td className="border border-slate-300 px-5 py-4 font-semibold bg-slate-50">
                      <div className="flex items-center gap-2">
                        <FaPhone />
                        Phone Number
                      </div>
                    </td>

                    <td className="border border-slate-300 px-5 py-4">
                      {profile.phone}
                    </td>

                  </tr>

                  <tr>

                    <td className="border border-slate-300 px-5 py-4 font-semibold bg-slate-50">
                      <div className="flex items-center gap-2">
                        <FaVenusMars />
                        Gender
                      </div>
                    </td>

                    <td className="border border-slate-300 px-5 py-4">
                      {profile.gender}
                    </td>

                  </tr>

                </tbody>

              </table>

            </div>

          </div>


        </div>

      </div>

      {/* Edit Profile Modal */}

      {showEditModal && (

        <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50 px-4">

          <div className="bg-white rounded-3xl w-full max-w-md shadow-2xl">

            <div className="flex justify-between items-center p-5 border-b">

              <h2 className="text-xl font-bold">
                Edit Profile
              </h2>

              <button
                onClick={() =>
                  setShowEditModal(false)
                }
                className="text-slate-500 hover:text-red-500"
              >
                <FaTimes size={20} />
              </button>

            </div>

            <div className="p-5 space-y-4">

              <input
                type="text"
                value={formData.name}
                onChange={(e) =>
                  setFormData({
                    ...formData,
                    name: e.target.value,
                  })
                }
                placeholder="Full Name"
                className="w-full border border-slate-300 rounded-xl px-4 py-3 outline-none"
              />

              <input
                type="email"
                value={formData.email}
                onChange={(e) =>
                  setFormData({
                    ...formData,
                    email: e.target.value,
                  })
                }
                placeholder="Email"
                className="w-full border border-slate-300 rounded-xl px-4 py-3 outline-none"
              />

              <input
                type="tel"
                value={formData.phone}
                onChange={(e) =>
                  setFormData({
                    ...formData,
                    phone: e.target.value,
                  })
                }
                placeholder="Phone Number"
                className="w-full border border-slate-300 rounded-xl px-4 py-3 outline-none"
              />

              <select
                value={formData.gender}
                onChange={(e) =>
                  setFormData({
                    ...formData,
                    gender: e.target.value,
                  })
                }
                className="w-full border border-slate-300 rounded-xl px-4 py-3 outline-none"
              >
                <option value="Male">
                  Male
                </option>

                <option value="Female">
                  Female
                </option>

                <option value="Other">
                  Other
                </option>

              </select>

            </div>

            <div className="p-5 border-t flex gap-3">

              <button
                onClick={handleSave}
                className="
                  flex-1
                  bg-blue-600
                  hover:bg-blue-700
                  text-white
                  py-3
                  rounded-xl
                  font-semibold
                  flex
                  justify-center
                  items-center
                  gap-2
                "
              >
                <FaSave />
                Save Changes
              </button>

              <button
                onClick={() =>
                  setShowEditModal(false)
                }
                className="
                  flex-1
                  border
                  border-slate-300
                  py-3
                  rounded-xl
                  font-semibold
                "
              >
                Cancel
              </button>

            </div>

          </div>

        </div>

      )}

      <Footer />

    </div>
  );
}