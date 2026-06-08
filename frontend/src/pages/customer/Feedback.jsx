import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  FaStar,
  FaBus,
  FaRoute,
  FaCalendarAlt,
  FaCheckCircle,
} from "react-icons/fa";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function Feedback() {
  const navigate = useNavigate();
  const [rating, setRating] = useState(0);

  const [hover, setHover] = useState(0);

  const [feedback, setFeedback] =
    useState("");

  const [submitted, setSubmitted] =
    useState(false);

  const booking = {
    bookingId: "TX102",
    busName: "Shivneri Travels",
    route: "Pune → Latur",
    journeyDate: "18-Apr-2026",
  };

  const handleSubmit = (e) => {
  e.preventDefault();

  setSubmitted(true);

  setTimeout(() => {
    navigate("/booking-history");
  }, 2000);
};

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-8">

        <div className="max-w-5xl mx-auto">

          {/* Booking Details */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md overflow-hidden">

            <div className="bg-blue-600 px-6 py-5">

              <h1 className="text-2xl font-black text-white">
                Journey Feedback
              </h1>

            </div>

            <div className="p-6">

              <table className="w-full border-collapse">

                <tbody>

                  <tr>

                    <td className="border border-slate-300 px-5 py-4 font-semibold bg-slate-50 w-56">
                      Booking ID
                    </td>

                    <td className="border border-slate-300 px-5 py-4">
                      {booking.bookingId}
                    </td>

                  </tr>

                  <tr>

                    <td className="border border-slate-300 px-5 py-4 font-semibold bg-slate-50">
                      <div className="flex items-center gap-2">
                        <FaBus />
                        Bus Name
                      </div>
                    </td>

                    <td className="border border-slate-300 px-5 py-4">
                      {booking.busName}
                    </td>

                  </tr>

                  <tr>

                    <td className="border border-slate-300 px-5 py-4 font-semibold bg-slate-50">
                      <div className="flex items-center gap-2">
                        <FaRoute />
                        Route
                      </div>
                    </td>

                    <td className="border border-slate-300 px-5 py-4">
                      {booking.route}
                    </td>

                  </tr>

                  <tr>

                    <td className="border border-slate-300 px-5 py-4 font-semibold bg-slate-50">
                      <div className="flex items-center gap-2">
                        <FaCalendarAlt />
                        Journey Date
                      </div>
                    </td>

                    <td className="border border-slate-300 px-5 py-4">
                      {booking.journeyDate}
                    </td>

                  </tr>

                </tbody>

              </table>

            </div>

          </div>

          {/* Feedback Form */}

          <div className="bg-white rounded-3xl border border-slate-200 shadow-md mt-8 overflow-hidden">

            <div className="bg-slate-900 px-6 py-5">

              <h2 className="text-xl font-bold text-white">
                Rate Your Journey
              </h2>

            </div>

            <form
              onSubmit={handleSubmit}
              className="p-6"
            >

              {/* Rating */}

              <div className="mb-8">

                <label className="block font-semibold text-slate-800 mb-4">

                  Overall Rating

                </label>

                <div className="flex gap-3">

                  {[...Array(5)].map(
                    (_, index) => {
                      const current =
                        index + 1;

                      return (
                        <button
                          key={current}
                          type="button"
                          onClick={() =>
                            setRating(
                              current
                            )
                          }
                          onMouseEnter={() =>
                            setHover(
                              current
                            )
                          }
                          onMouseLeave={() =>
                            setHover(0)
                          }
                          className="text-4xl"
                        >
                          <FaStar
                            className={
                              current <=
                              (hover ||
                                rating)
                                ? "text-yellow-400"
                                : "text-slate-300"
                            }
                          />
                        </button>
                      );
                    }
                  )}

                </div>

                {rating > 0 && (

                  <p className="mt-3 text-slate-600">

                    You rated this journey{" "}

                    <span className="font-bold">
                      {rating}/5
                    </span>

                  </p>

                )}

              </div>

              {/* Feedback */}

              <div>

                <label className="block font-semibold text-slate-800 mb-3">

                  Share Your Experience

                </label>

                <textarea
                  rows="6"
                  value={feedback}
                  onChange={(e) =>
                    setFeedback(
                      e.target.value
                    )
                  }
                  placeholder="Tell us about your travel experience..."
                  className="
                    w-full
                    border
                    border-slate-300
                    rounded-xl
                    px-4
                    py-3
                    resize-none
                    outline-none
                    focus:ring-2
                    focus:ring-blue-200
                  "
                />

              </div>

              {/* Submit */}

              <div className="mt-8">

                <button
                  type="submit"
                  disabled={
                    rating === 0 ||
                    !feedback.trim()
                  }
                  className="
                    w-full
                    bg-blue-600
                    hover:bg-blue-700
                    text-white
                    py-3.5
                    rounded-xl
                    font-semibold
                    text-lg
                    transition
                    disabled:bg-slate-300
                    disabled:cursor-not-allowed
                  "
                >
                  Submit Feedback
                </button>

              </div>

            </form>

          </div>

        </div>

      </div>

      {/* Success Popup */}

      {submitted && (

        <div className="fixed inset-0 bg-black/40 flex items-center justify-center z-50 px-4">

          <div className="bg-white rounded-3xl shadow-2xl p-8 max-w-md w-full text-center">

            <FaCheckCircle className="text-green-500 text-6xl mx-auto mb-4" />

            <h3 className="text-2xl font-bold text-slate-900 mb-3">
              Feedback Submitted
            </h3>

            <p className="text-slate-600">
              Thank you for sharing your experience.
              Your feedback helps us improve our service.
            </p>

          </div>

        </div>

      )}

      <Footer />

    </div>
  );
}