import React, { useState } from "react";
import {
  useNavigate,
  useLocation,
} from "react-router-dom";

import {
  FaArrowLeft,
  FaBus,
  FaChair,
  FaMapMarkerAlt,
  FaMoneyBillWave,
  FaUser,
  FaPhone,
  FaCreditCard,
  FaUniversity,
  FaWallet,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function Payment() {
  const navigate = useNavigate();
  const { state } = useLocation();

  const {
    bus,
    selectedSeats = [],
    boarding = "",
    dropping = "",
    totalAmount = 0,
    passenger,
  } = state || {};

  const [paymentMethod, setPaymentMethod] =
    useState("upi");

  const handlePayment = () => {
    navigate("/booking-history", {
      state: {
        bus,
        selectedSeats,
        boarding,
        dropping,
        totalAmount,
        passenger,
        paymentMethod,
      },
    });
  };

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-6">

        <div className="max-w-5xl mx-auto">

          {/* Back */}

          <button
            onClick={() => navigate(-1)}
            className="flex items-center gap-2 text-blue-600 font-semibold mb-5 hover:text-blue-700"
          >
            <FaArrowLeft />
            Back to Passenger Details
          </button>

          <div className="grid lg:grid-cols-3 gap-6">

            {/* Left Section */}

            <div className="lg:col-span-2">

              <div className="bg-white rounded-3xl border border-slate-200 shadow-lg p-6">

                <h1 className="text-3xl font-black text-slate-900 mb-6">
                  Payment
                </h1>

                <div className="space-y-4">

                  {/* UPI */}

                  <label className="flex items-center gap-4 border rounded-2xl p-4 cursor-pointer hover:border-blue-500">

                    <input
                      type="radio"
                      checked={
                        paymentMethod === "upi"
                      }
                      onChange={() =>
                        setPaymentMethod("upi")
                      }
                    />

                    <FaWallet className="text-2xl text-blue-600" />

                    <span className="font-semibold">
                      UPI Payment
                    </span>

                  </label>

                  {/* Card */}

                  <label className="flex items-center gap-4 border rounded-2xl p-4 cursor-pointer hover:border-blue-500">

                    <input
                      type="radio"
                      checked={
                        paymentMethod === "card"
                      }
                      onChange={() =>
                        setPaymentMethod("card")
                      }
                    />

                    <FaCreditCard className="text-2xl text-blue-600" />

                    <span className="font-semibold">
                      Debit / Credit Card
                    </span>

                  </label>

                  {/* Net Banking */}

                  <label className="flex items-center gap-4 border rounded-2xl p-4 cursor-pointer hover:border-blue-500">

                    <input
                      type="radio"
                      checked={
                        paymentMethod ===
                        "netbanking"
                      }
                      onChange={() =>
                        setPaymentMethod(
                          "netbanking"
                        )
                      }
                    />

                    <FaUniversity className="text-2xl text-blue-600" />

                    <span className="font-semibold">
                      Net Banking
                    </span>

                  </label>

                </div>

                {/* Payment Fields */}

                <div className="mt-6">

                  {paymentMethod === "upi" && (
                    <input
                      type="text"
                      placeholder="Enter UPI ID"
                      className="w-full h-12 px-4 border border-slate-300 rounded-xl"
                    />
                  )}

                  {paymentMethod === "card" && (
                    <div className="space-y-4">

                      <input
                        type="text"
                        placeholder="Card Number"
                        className="w-full h-12 px-4 border border-slate-300 rounded-xl"
                      />

                      <div className="grid grid-cols-2 gap-4">

                        <input
                          type="text"
                          placeholder="MM/YY"
                          className="h-12 px-4 border border-slate-300 rounded-xl"
                        />

                        <input
                          type="password"
                          placeholder="CVV"
                          className="h-12 px-4 border border-slate-300 rounded-xl"
                        />

                      </div>

                    </div>
                  )}

                  {paymentMethod ===
                    "netbanking" && (
                    <select className="w-full h-12 px-4 border border-slate-300 rounded-xl">
                      <option>
                        Select Bank
                      </option>
                      <option>
                        SBI
                      </option>
                      <option>
                        HDFC
                      </option>
                      <option>
                        ICICI
                      </option>
                      <option>
                        Axis Bank
                      </option>
                    </select>
                  )}

                </div>

              </div>

            </div>

            {/* Right Section */}

            <div>

              <div className="bg-white rounded-3xl border border-slate-200 shadow-lg p-6 sticky top-6">

                <h2 className="text-2xl font-bold mb-5">
                  Booking Summary
                </h2>

                <div className="space-y-4">

                  <div className="flex justify-between">

                    <span className="flex items-center gap-2">
                      <FaBus />
                      Route
                    </span>

                    <span>
                      {bus?.route}
                    </span>

                  </div>

                  <div className="flex justify-between">

                    <span className="flex items-center gap-2">
                      <FaChair />
                      Seats
                    </span>

                    <span>
                      {selectedSeats.join(
                        ", "
                      )}
                    </span>

                  </div>

                  <div className="flex justify-between">

                    <span className="flex items-center gap-2">
                      <FaMapMarkerAlt />
                      Boarding
                    </span>

                    <span>
                      {boarding}
                    </span>

                  </div>

                  <div className="flex justify-between">

                    <span className="flex items-center gap-2">
                      <FaMapMarkerAlt />
                      Dropping
                    </span>

                    <span>
                      {dropping}
                    </span>

                  </div>

                  <hr />

                  <div>

                    <h3 className="font-bold mb-3">
                      Passenger
                    </h3>

                    <div className="space-y-2 text-sm">

                      <p className="flex items-center gap-2">
                        <FaUser />
                        {passenger?.name}
                      </p>

                      <p className="flex items-center gap-2">
                        <FaPhone />
                        {passenger?.phone}
                      </p>

                    </div>

                  </div>

                  <hr />

                  <div className="flex justify-between items-center">

                    <span className="font-bold text-lg flex items-center gap-2">
                      <FaMoneyBillWave />
                      Total
                    </span>

                    <span className="text-3xl font-black text-green-600">
                      ₹{totalAmount}
                    </span>

                  </div>

                </div>

                <button
                  onClick={handlePayment}
                  className="
                    w-full
                    mt-6
                    h-14
                    bg-blue-600
                    hover:bg-blue-700
                    text-white
                    rounded-xl
                    font-bold
                    text-lg
                    transition
                  "
                >
                  Pay ₹{totalAmount}
                </button>

              </div>

            </div>

          </div>

        </div>

      </div>

      <Footer />

    </div>
  );
}