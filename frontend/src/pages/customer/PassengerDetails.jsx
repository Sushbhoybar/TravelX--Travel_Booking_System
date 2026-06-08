import React, { useState } from "react";
import {
  useNavigate,
  useLocation,
} from "react-router-dom";

import {
  FaArrowLeft,
  FaUser,
  FaPhone,
  FaBus,
  FaChair,
  FaMapMarkerAlt,
  FaMoneyBillWave,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function PassengerDetails() {
  const navigate = useNavigate();
  const { state } = useLocation();

  const {
    bus,
    selectedSeats = [],
    boarding = "",
    dropping = "",
    totalAmount = 0,
  } = state || {};

  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [gender, setGender] = useState("Male");
  const [phone, setPhone] = useState("");

  const handleProceed = () => {
    navigate("/payment", {
      state: {
        bus,
        selectedSeats,
        boarding,
        dropping,
        totalAmount,
        passenger: {
          name,
          age,
          gender,
          phone,
        },
      },
    });
  };

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-6">

        <div className="max-w-3xl mx-auto">

          {/* Back Button */}

          <button
            onClick={() => navigate(-1)}
            className="flex items-center gap-2 text-blue-600 font-semibold mb-5 hover:text-blue-700"
          >
            <FaArrowLeft />
            Back to Seat Selection
          </button>

          {/* Main Card */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-lg p-8">

            {/* Title */}

            <div className="text-center mb-8">

              <h1 className="text-3xl font-black text-slate-900">
                Passenger Details
              </h1>

              <p className="text-slate-500 mt-2">
                Enter passenger information to continue
              </p>

            </div>

            {/* Passenger Form */}

            <div className="space-y-5">

              <div>

                <label className="block text-sm font-semibold text-slate-700 mb-2">
                  Passenger Name
                </label>

                <div className="relative">

                  <FaUser className="absolute left-4 top-1/2 -translate-y-1/2 text-slate-400" />

                  <input
                    type="text"
                    value={name}
                    onChange={(e) =>
                      setName(e.target.value)
                    }
                    placeholder="Enter Full Name"
                    className="w-full h-12 pl-12 pr-4 border border-slate-300 rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-500"
                  />

                </div>

              </div>

              <div>

                <label className="block text-sm font-semibold text-slate-700 mb-2">
                  Age
                </label>

                <input
                  type="number"
                  value={age}
                  onChange={(e) =>
                    setAge(e.target.value)
                  }
                  placeholder="Enter Age"
                  className="w-full h-12 px-4 border border-slate-300 rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-500"
                />

              </div>

              <div>

                <label className="block text-sm font-semibold text-slate-700 mb-2">
                  Gender
                </label>

                <select
                  value={gender}
                  onChange={(e) =>
                    setGender(e.target.value)
                  }
                  className="w-full h-12 px-4 border border-slate-300 rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-500"
                >
                  <option>Male</option>
                  <option>Female</option>
                  <option>Other</option>
                </select>

              </div>

              <div>

                <label className="block text-sm font-semibold text-slate-700 mb-2">
                  Mobile Number
                </label>

                <div className="relative">

                  <FaPhone className="absolute left-4 top-1/2 -translate-y-1/2 text-slate-400" />

                  <input
                    type="tel"
                    value={phone}
                    onChange={(e) =>
                      setPhone(e.target.value)
                    }
                    placeholder="Enter Mobile Number"
                    className="w-full h-12 pl-12 pr-4 border border-slate-300 rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-500"
                  />

                </div>

              </div>

            </div>

            {/* Booking Summary */}

            <div className="mt-8 bg-slate-50 border border-slate-200 rounded-2xl p-6">

              <h2 className="text-2xl font-bold text-center mb-5">
                Booking Summary
              </h2>

              <div className="space-y-4">

                <div className="flex justify-between border-b pb-3">

                  <span className="font-semibold flex items-center gap-2">
                    <FaBus />
                    Route
                  </span>

                  <span>
                    {bus?.route || "Pune → Latur"}
                  </span>

                </div>

                <div className="flex justify-between border-b pb-3">

                  <span className="font-semibold flex items-center gap-2">
                    <FaChair />
                    Seats
                  </span>

                  <span>
                    {selectedSeats.join(", ")}
                  </span>

                </div>

                <div className="flex justify-between border-b pb-3">

                  <span className="font-semibold flex items-center gap-2">
                    <FaMapMarkerAlt />
                    Boarding
                  </span>

                  <span>{boarding}</span>

                </div>

                <div className="flex justify-between border-b pb-3">

                  <span className="font-semibold flex items-center gap-2">
                    <FaMapMarkerAlt />
                    Dropping
                  </span>

                  <span>{dropping}</span>

                </div>

                <div className="flex justify-between">

                  <span className="font-semibold flex items-center gap-2">
                    <FaMoneyBillWave />
                    Total Fare
                  </span>

                  <span className="text-2xl font-black text-green-600">
                    ₹{totalAmount}
                  </span>

                </div>

              </div>

            </div>

            {/* Button */}

            <div className="mt-8">

              <button
                onClick={handleProceed}
                disabled={
                  !name ||
                  !age ||
                  !phone
                }
                className="
                  w-full
                  h-14
                  bg-blue-600
                  hover:bg-blue-700
                  text-white
                  rounded-xl
                  font-bold
                  text-lg
                  transition
                  disabled:bg-slate-300
                  disabled:cursor-not-allowed
                "
              >
                Proceed to Payment
              </button>

            </div>

          </div>

        </div>

      </div>

      <Footer />

    </div>
  );
}