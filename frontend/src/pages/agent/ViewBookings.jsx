import { useNavigate } from "react-router-dom";

function ViewBookings() {
    const navigate = useNavigate();

    const trips = [
        {
            id: 1,
            busName: "Shivneri Travels",
            busNumber: "MH12 AB 1234",
            route: "Pune → Latur",
            date: "20-Apr-2026",
            departureTime: "08:30 PM",
            bookedSeats: 25,
            totalSeats: 40,
        },
        {
            id: 2,
            busName: "Royal Express",
            busNumber: "MH14 CD 5678",
            route: "Mumbai → Pune",
            date: "22-Apr-2026",
            departureTime: "10:00 PM",
            bookedSeats: 18,
            totalSeats: 45,
        },
        {
            id: 3,
            busName: "Sai Travels",
            busNumber: "MH11 XY 9087",
            route: "Satara → Mumbai",
            date: "25-Apr-2026",
            departureTime: "07:15 PM",
            bookedSeats: 30,
            totalSeats: 50,
        },
    ];

    const handleViewPassengers = (tripId) => {
        navigate(`/agent/passengers/${tripId}`);
    };

    return (
        <div className="min-h-screen bg-[#f5f7fb] flex justify-center items-start px-5 py-12 font-sans">
            <div className="w-full max-w-5xl bg-white border border-gray-300 rounded-xl px-8 py-9 shadow-md">
                <div className="w-[75px] h-[75px] bg-[#eef3ff] text-[#1d4ed8] rounded-full mx-auto mb-4 flex items-center justify-center text-4xl">
                    🎟️
                </div>

                <h2 className="text-center text-3xl font-bold text-gray-900">
                    Select Bus to View Bookings
                </h2>

                <p className="text-center text-gray-600 text-sm mt-2 mb-8">
                    Choose a bus trip to see the passenger booking list
                </p>

                <div className="overflow-x-auto border border-gray-300 rounded-lg">
                    <table className="w-full border-collapse bg-white">
                        <thead>
                            <tr className="bg-[#eef3ff] text-gray-900">
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Bus Name
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Bus Number
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Route
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Date
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Time
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Booked Seats
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Action
                                </th>
                            </tr>
                        </thead>

                        <tbody>
                            {trips.map((trip) => (
                                <tr
                                    key={trip.id}
                                    className="hover:bg-[#f9fbff] transition"
                                >
                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-800 font-semibold">
                                        {trip.busName}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700">
                                        {trip.busNumber}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700">
                                        {trip.route}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700">
                                        {trip.date}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700">
                                        {trip.departureTime}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm">
                                        <span className="bg-blue-100 text-blue-700 px-3 py-1 rounded-full font-semibold">
                                            {trip.bookedSeats}/{trip.totalSeats}
                                        </span>
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center">
                                        <button
                                            onClick={() => handleViewPassengers(trip.id)}
                                            className="bg-gray-900 text-white px-5 py-2 rounded-md text-sm font-semibold hover:bg-blue-700 transition"
                                        >
                                            View
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>

                <button
                    onClick={() => navigate("/agent/dashboard")}
                    className="w-full h-11 bg-white text-gray-900 border border-gray-900 rounded-md text-[15px] font-semibold mt-7 hover:bg-[#eef3ff] hover:text-blue-700 hover:border-blue-700 transition"
                >
                    Back to Dashboard
                </button>
            </div>
        </div>
    );
}

export default ViewBookings;