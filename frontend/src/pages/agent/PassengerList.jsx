import { useNavigate, useParams } from "react-router-dom";

function PassengerList() {
    const navigate = useNavigate();
    const { tripId } = useParams();

    // Temporary trip data
    // Later this data will come from backend using tripId
    const tripDetails = {
        id: tripId,
        busName: "Shivneri",
        route: "Pune → Latur",
        date: "20-Apr-2026",
    };

    const passengers = [
        {
            bookingId: "TX101",
            passengerName: "Rahul",
            seat: "A1",
            boarding: "Pune Station",
            dropping: "Latur Stand",
            status: "Confirmed",
        },
        {
            bookingId: "TX102",
            passengerName: "Amit",
            seat: "B2",
            boarding: "Swargate",
            dropping: "Latur Stand",
            status: "Cancelled",
        },
        {
            bookingId: "TX103",
            passengerName: "Suresh",
            seat: "A3",
            boarding: "Pune Station",
            dropping: "Latur Stand",
            status: "Confirmed",
        },
        {
            bookingId: "TX104",
            passengerName: "Priya",
            seat: "C1",
            boarding: "Katraj",
            dropping: "Latur Stand",
            status: "Confirmed",
        },
    ];

    return (
        <div className="min-h-screen bg-[#f5f7fb] flex justify-center items-start px-5 py-12 font-sans">
            <div className="w-full max-w-5xl bg-white border border-gray-300 rounded-xl px-8 py-9 shadow-md">
                <div className="w-[75px] h-[75px] bg-[#eef3ff] text-[#1d4ed8] rounded-full mx-auto mb-4 flex items-center justify-center text-4xl">
                    👥
                </div>

                <h2 className="text-center text-3xl font-bold text-gray-900">
                    Passenger List
                </h2>

                <p className="text-center text-gray-600 text-sm mt-2 mb-8">
                    View passenger booking details for the selected bus trip
                </p>

                {/* Trip Info Box */}
                <div className="border border-gray-300 rounded-lg px-5 py-4 mb-6 bg-white">
                    <div className="flex flex-col md:flex-row justify-center items-center gap-3 md:gap-6 text-gray-900 text-base">
                        <p>
                            <span className="font-bold">Bus:</span> {tripDetails.busName}
                        </p>

                        <span className="hidden md:block text-gray-500 font-bold">|</span>

                        <p>
                            <span className="font-bold">Route:</span> {tripDetails.route}
                        </p>

                        <span className="hidden md:block text-gray-500 font-bold">|</span>

                        <p>
                            <span className="font-bold">Date:</span> {tripDetails.date}
                        </p>
                    </div>
                </div>

                {/* Passenger Table */}
                <div className="overflow-x-auto border border-gray-300 rounded-lg">
                    <table className="w-full border-collapse bg-white">
                        <thead>
                            <tr className="bg-[#eef3ff] text-gray-900">
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Booking ID
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Passenger
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Seat
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Boarding
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Dropping
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Status
                                </th>
                            </tr>
                        </thead>

                        <tbody>
                            {passengers.map((passenger) => (
                                <tr
                                    key={passenger.bookingId}
                                    className="hover:bg-[#f9fbff] transition"
                                >
                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-800 font-semibold">
                                        {passenger.bookingId}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700">
                                        {passenger.passengerName}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700 font-semibold">
                                        {passenger.seat}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700">
                                        {passenger.boarding}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700">
                                        {passenger.dropping}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center">
                                        <span
                                            className={
                                                passenger.status === "Confirmed"
                                                    ? "inline-block min-w-[95px] border border-green-500 text-green-700 bg-green-50 px-3 py-2 rounded-md text-sm font-bold"
                                                    : "inline-block min-w-[95px] border border-red-500 text-red-700 bg-red-50 px-3 py-2 rounded-md text-sm font-bold"
                                            }
                                        >
                                            {passenger.status}
                                        </span>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>

                {/* Summary */}
                <div className="grid grid-cols-1 sm:grid-cols-3 gap-4 mt-7">
                    <div className="bg-[#eef3ff] border border-blue-100 rounded-lg p-4 text-center">
                        <p className="text-sm text-gray-600 font-semibold">
                            Total Passengers
                        </p>
                        <h3 className="text-2xl font-bold text-gray-900 mt-1">
                            {passengers.length}
                        </h3>
                    </div>

                    <div className="bg-green-50 border border-green-200 rounded-lg p-4 text-center">
                        <p className="text-sm text-gray-600 font-semibold">Confirmed</p>
                        <h3 className="text-2xl font-bold text-green-700 mt-1">
                            {
                                passengers.filter(
                                    (passenger) => passenger.status === "Confirmed"
                                ).length
                            }
                        </h3>
                    </div>

                    <div className="bg-red-50 border border-red-200 rounded-lg p-4 text-center">
                        <p className="text-sm text-gray-600 font-semibold">Cancelled</p>
                        <h3 className="text-2xl font-bold text-red-700 mt-1">
                            {
                                passengers.filter(
                                    (passenger) => passenger.status === "Cancelled"
                                ).length
                            }
                        </h3>
                    </div>
                </div>

                <button
                    onClick={() => navigate("/agent/view-bookings")}
                    className="w-full h-11 bg-white text-gray-900 border border-gray-900 rounded-md text-[15px] font-semibold mt-7 hover:bg-[#eef3ff] hover:text-blue-700 hover:border-blue-700 transition"
                >
                    Back to View Bookings
                </button>
            </div>
        </div>
    );
}

export default PassengerList;