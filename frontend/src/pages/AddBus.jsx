import { useState } from "react";
import { useNavigate } from "react-router-dom";

function AddBus() {
    const navigate = useNavigate();

    const [busData, setBusData] = useState({
        busName: "",
        busNumber: "",
        busType: "",
        totalSeats: "",
        seatLayout: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;

        setBusData({
            ...busData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        console.log("Bus Data:", busData);
        alert("Bus added successfully!");

        setBusData({
            busName: "",
            busNumber: "",
            busType: "",
            totalSeats: "",
            seatLayout: "",
        });

        navigate("/agent/dashboard");
    };

    return (
        <div className="min-h-screen bg-[#f5f7fb] flex justify-center items-start px-5 py-12 font-sans">
            <div className="w-full max-w-xl bg-white border border-gray-300 rounded-xl px-8 py-9 shadow-md">
                <div className="w-[75px] h-[75px] bg-[#eef3ff] text-[#1d4ed8] rounded-full mx-auto mb-4 flex items-center justify-center text-4xl">
                    🚌
                </div>

                <h2 className="text-center text-3xl font-bold text-gray-900">
                    Add New Bus
                </h2>

                <p className="text-center text-gray-600 text-sm mt-2 mb-8">
                    Enter bus details to add it to your travel service
                </p>

                <form onSubmit={handleSubmit}>
                    <div className="mb-4">
                        <label className="block text-sm font-semibold text-gray-800 mb-2">
                            Bus Name
                        </label>
                        <input
                            type="text"
                            name="busName"
                            value={busData.busName}
                            onChange={handleChange}
                            placeholder="Enter bus name"
                            required
                            className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-sm font-semibold text-gray-800 mb-2">
                            Bus Number
                        </label>
                        <input
                            type="text"
                            name="busNumber"
                            value={busData.busNumber}
                            onChange={handleChange}
                            placeholder="Example: MH12 AB 1234"
                            required
                            className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                        />
                    </div>

                    <div className="mb-4">
                        <label className="block text-sm font-semibold text-gray-800 mb-2">
                            Bus Type
                        </label>
                        <select
                            name="busType"
                            value={busData.busType}
                            onChange={handleChange}
                            required
                            className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none bg-white focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                        >
                            <option value="">Select bus type</option>
                            <option value="AC Sleeper">AC Sleeper</option>
                            <option value="Non-AC Sleeper">Non-AC Sleeper</option>
                            <option value="AC Seater">AC Seater</option>
                            <option value="Non-AC Seater">Non-AC Seater</option>
                            <option value="Volvo">Volvo</option>
                            <option value="Luxury">Luxury</option>
                        </select>
                    </div>

                    <div className="mb-4">
                        <label className="block text-sm font-semibold text-gray-800 mb-2">
                            Total Seats
                        </label>
                        <input
                            type="number"
                            name="totalSeats"
                            value={busData.totalSeats}
                            onChange={handleChange}
                            placeholder="Enter total seats"
                            min="1"
                            required
                            className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                        />
                    </div>

                    <div className="mb-5">
                        <label className="block text-sm font-semibold text-gray-800 mb-2">
                            Seat Layout
                        </label>
                        <select
                            name="seatLayout"
                            value={busData.seatLayout}
                            onChange={handleChange}
                            required
                            className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none bg-white focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                        >
                            <option value="">Select seat layout</option>
                            <option value="2x2">2 x 2</option>
                            <option value="2x1">2 x 1</option>
                            <option value="1x1">1 x 1</option>
                            <option value="Sleeper 2x1">Sleeper 2 x 1</option>
                        </select>
                    </div>

                    <button
                        type="submit"
                        className="w-full h-12 bg-gray-900 text-white rounded-md text-base font-semibold mt-4 hover:bg-blue-700 transition"
                    >
                        Add Bus
                    </button>

                    <button
                        type="button"
                        onClick={() => navigate("/agent/dashboard")}
                        className="w-full h-11 bg-white text-gray-900 border border-gray-900 rounded-md text-[15px] font-semibold mt-3 hover:bg-[#eef3ff] hover:text-blue-700 hover:border-blue-700 transition"
                    >
                        Back to Dashboard
                    </button>
                </form>
            </div>
        </div>
    );
}

export default AddBus;