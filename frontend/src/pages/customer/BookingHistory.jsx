import React from "react";
import { useNavigate } from "react-router-dom";

import Header from "../../components/customer/Header";
import Footer from "../../components/customer/Footer";

export default function BookingHistory() {
  const navigate = useNavigate();

  const bookings = [
    {
      id: "TX101",
      route: "Pune → Latur",
      date: "20-Apr-2026",
      status: "Confirmed",
    },
    {
      id: "TX102",
      route: "Pune → Latur",
      date: "18-Apr-2026",
      status: "Completed",
    },
    {
      id: "TX103",
      route: "Pune → Latur",
      date: "17-Apr-2026",
      status: "Cancelled",
    },
    {
      id: "TX104",
      route: "Pune → Latur",
      date: "25-Apr-2026",
      status: "Confirmed",
    },
    {
      id: "TX105",
      route: "Pune → Latur",
      date: "15-Apr-2026",
      status: "Completed",
    },
  ];

  const getStatusStyle = (status) => {
    switch (status) {
      case "Confirmed":
        return "bg-green-100 text-green-700 border-green-300";

      case "Completed":
        return "bg-blue-100 text-blue-700 border-blue-300";

      case "Cancelled":
        return "bg-red-100 text-red-700 border-red-300";

      default:
        return "bg-slate-100 text-slate-700 border-slate-300";
    }
  };

  return (
    <div className="min-h-screen bg-slate-100 flex flex-col">

      <Header />

      <div className="flex-1 px-4 py-8">

        <div className="max-w-7xl mx-auto">

          <div className="bg-white rounded-3xl border border-slate-300 shadow-md overflow-hidden">

            <div className="overflow-x-auto">

              <table className="w-full border-collapse">

                <thead>

                  <tr className="bg-slate-100">

                    <th className="border border-slate-300 px-6 py-5 text-center text-lg font-bold">
                      Booking ID
                    </th>

                    <th className="border border-slate-300 px-6 py-5 text-center text-lg font-bold">
                      Route
                    </th>

                    <th className="border border-slate-300 px-6 py-5 text-center text-lg font-bold">
                      Date
                    </th>

                    <th className="border border-slate-300 px-6 py-5 text-center text-lg font-bold">
                      Status
                    </th>

                    <th className="border border-slate-300 px-6 py-5 text-center text-lg font-bold">
                      Action
                    </th>

                  </tr>

                </thead>

                <tbody>

                  {bookings.map((booking) => (

                    <tr
                      key={booking.id}
                      className="hover:bg-slate-50 transition"
                    >

                      <td className="border border-slate-300 px-6 py-8 text-center font-semibold text-lg">
                        {booking.id}
                      </td>

                      <td className="border border-slate-300 px-6 py-8 text-center text-lg">
                        {booking.route}
                      </td>

                      <td className="border border-slate-300 px-6 py-8 text-center text-lg">
                        {booking.date}
                      </td>

                      <td className="border border-slate-300 px-6 py-8 text-center">

                        <span
                          className={`
                            inline-block
                            min-w-[130px]
                            px-4
                            py-2
                            rounded-lg
                            border
                            font-semibold
                            ${getStatusStyle(booking.status)}
                          `}
                        >
                          {booking.status}
                        </span>

                      </td>

                      <td className="border border-slate-300 px-6 py-8">

                        <div className="flex justify-center items-center gap-3 flex-wrap">

                          <button
                            onClick={() =>
                              navigate(`/booking-details/${booking.id}`)
                            }
                            className="
                              min-w-[110px]
                              bg-slate-900
                              hover:bg-slate-800
                              text-white
                              px-4
                              py-2.5
                              rounded-lg
                              font-semibold
                              transition
                            "
                          >
                            View Details
                          </button>

                          {booking.status === "Completed" && (

  <button
    onClick={() => navigate("/feedback")}
    className="
      min-w-[100px]
      border
      border-blue-600
      text-blue-600
      hover:bg-blue-600
      hover:text-white
      px-4
      py-2.5
      rounded-lg
      font-semibold
      transition
    "
  >
    Feedback
  </button>

)}

                          {booking.status === "Confirmed" && (

                            <button
                              className="
                                min-w-[100px]
                                border
                                border-red-600
                                text-red-600
                                hover:bg-red-600
                                hover:text-white
                                px-4
                                py-2.5
                                rounded-lg
                                font-semibold
                                transition
                              "
                            >
                              Cancel
                            </button>

                          )}

                        </div>

                      </td>

                    </tr>

                  ))}

                </tbody>

              </table>

            </div>

          </div>

        </div>

      </div>

      <Footer />

    </div>
  );
}