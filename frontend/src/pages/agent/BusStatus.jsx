import { useNavigate } from "react-router-dom";

function BusStatus() {
    const navigate = useNavigate();

    const buses = [
        {
            id: 1,
            busName: "Shivneri",
            numberPlate: "MH24AP2345",
            status: "Approved",
        },
        {
            id: 2,
            busName: "Express",
            numberPlate: "MH12XY1111",
            status: "Pending",
        },
        {
            id: 3,
            busName: "Deluxe",
            numberPlate: "MH14PQ2222",
            status: "Rejected",
        },
        {
            id: 4,
            busName: "Royal Travels",
            numberPlate: "MH11AB9087",
            status: "Approved",
        },
    ];

    const getStatusClass = (status) => {
        if (status === "Approved") {
            return "border-green-500 text-green-700 bg-green-50";
        }

        if (status === "Pending") {
            return "border-yellow-500 text-yellow-600 bg-yellow-50";
        }

        return "border-red-500 text-red-700 bg-red-50";
    };

    return (
        <div className="min-h-screen bg-[#f5f7fb] flex justify-center items-start px-5 py-12 font-sans">
            <div className="w-full max-w-4xl bg-white border border-gray-300 rounded-xl px-8 py-9 shadow-md">
                <div className="w-[75px] h-[75px] bg-[#eef3ff] text-[#1d4ed8] rounded-full mx-auto mb-4 flex items-center justify-center text-4xl">
                    📍
                </div>

                <h2 className="text-center text-3xl font-bold text-gray-900">
                    Bus Status
                </h2>

                <p className="text-center text-gray-600 text-sm mt-2 mb-8">
                    Check approval status of your registered buses
                </p>

                <div className="overflow-x-auto border border-gray-300 rounded-lg">
                    <table className="w-full border-collapse bg-white">
                        <thead>
                            <tr className="bg-[#eef3ff] text-gray-900">
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Bus Name
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Number Plate
                                </th>
                                <th className="border border-gray-300 px-4 py-4 text-center text-sm font-bold">
                                    Status
                                </th>
                            </tr>
                        </thead>

                        <tbody>
                            {buses.map((bus) => (
                                <tr key={bus.id} className="hover:bg-[#f9fbff] transition">
                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-800 font-semibold">
                                        {bus.busName}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center text-sm text-gray-700">
                                        {bus.numberPlate}
                                    </td>

                                    <td className="border border-gray-300 px-4 py-4 text-center">
                                        <span
                                            className={`inline-block min-w-[110px] border px-4 py-2 rounded-md text-sm font-bold ${getStatusClass(
                                                bus.status
                                            )}`}
                                        >
                                            {bus.status}
                                        </span>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>

                <div className="grid grid-cols-1 sm:grid-cols-3 gap-4 mt-7">
                    <div className="bg-green-50 border border-green-200 rounded-lg p-4 text-center">
                        <p className="text-sm text-gray-600 font-semibold">Approved</p>
                        <h3 className="text-2xl font-bold text-green-700 mt-1">
                            {buses.filter((bus) => bus.status === "Approved").length}
                        </h3>
                    </div>

                    <div className="bg-yellow-50 border border-yellow-200 rounded-lg p-4 text-center">
                        <p className="text-sm text-gray-600 font-semibold">Pending</p>
                        <h3 className="text-2xl font-bold text-yellow-600 mt-1">
                            {buses.filter((bus) => bus.status === "Pending").length}
                        </h3>
                    </div>

                    <div className="bg-red-50 border border-red-200 rounded-lg p-4 text-center">
                        <p className="text-sm text-gray-600 font-semibold">Rejected</p>
                        <h3 className="text-2xl font-bold text-red-700 mt-1">
                            {buses.filter((bus) => bus.status === "Rejected").length}
                        </h3>
                    </div>
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

export default BusStatus;