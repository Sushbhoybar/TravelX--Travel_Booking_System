import { useState } from "react";
import { useNavigate } from "react-router-dom";

function ManageTrips() {
    const navigate = useNavigate();

    const [tripData, setTripData] = useState({
        busId: "",
        from: "",
        to: "",
        journeyDate: "",
        departureTime: "",
        arrivalTime: "",
        pricePerSeat: "",
    });

    const [showFromSuggestions, setShowFromSuggestions] = useState(false);
    const [showToSuggestions, setShowToSuggestions] = useState(false);

    const buses = [
        {
            id: 1,
            busName: "Shivneri Travels",
            busNumber: "MH12 AB 1234",
        },
        {
            id: 2,
            busName: "Royal Express",
            busNumber: "MH14 CD 5678",
        },
        {
            id: 3,
            busName: "Sai Travels",
            busNumber: "MH11 XY 9087",
        },
    ];

    const cities = [
        "Mumbai",
        "Pune",
        "Nagpur",
        "Nashik",
        "Aurangabad",
        "Kolhapur",
        "Solapur",
        "Satara",
        "Sangli",
        "Ahmedabad",
        "Surat",
        "Vadodara",
        "Indore",
        "Bhopal",
        "Hyderabad",
        "Bengaluru",
        "Chennai",
        "Delhi",
        "Goa",
        "Puri",
        "Puducherry",
        "Jaipur",
        "Udaipur",
        "Lucknow",
        "Kanpur",
        "Mysore",
        "Mangalore",
        "Noida",
        "Gurgaon",
        "Thane",
        "Latur",
        "Nanded",
        "Akola",
        "Amravati",
        "Jalgaon",
        "Dhule",
        "Ratnagiri",
        "Panaji",
    ];

    const handleChange = (e) => {
        const { name, value } = e.target;

        setTripData({
            ...tripData,
            [name]: value,
        });
    };

    const getFilteredCities = (typedValue, otherSelectedCity = "") => {
        if (!typedValue.trim()) {
            return cities.filter((city) => city !== otherSelectedCity);
        }

        return cities.filter(
            (city) =>
                city.toLowerCase().includes(typedValue.toLowerCase()) &&
                city !== otherSelectedCity
        );
    };

    const selectFromCity = (city) => {
        setTripData({
            ...tripData,
            from: city,
            to: city === tripData.to ? "" : tripData.to,
        });

        setShowFromSuggestions(false);
    };

    const selectToCity = (city) => {
        setTripData({
            ...tripData,
            to: city,
        });

        setShowToSuggestions(false);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (tripData.from === tripData.to) {
            alert("Source and destination cannot be same");
            return;
        }

        console.log("Trip Data:", tripData);
        alert("Trip added successfully!");

        setTripData({
            busId: "",
            from: "",
            to: "",
            journeyDate: "",
            departureTime: "",
            arrivalTime: "",
            pricePerSeat: "",
        });

        navigate("/agent/dashboard");
    };

    return (
        <div className="min-h-screen bg-[#f5f7fb] flex justify-center items-start px-5 py-12 font-sans">
            <div className="w-full max-w-2xl bg-white border border-gray-300 rounded-xl px-8 py-9 shadow-md">
                <div className="w-[75px] h-[75px] bg-[#eef3ff] text-[#1d4ed8] rounded-full mx-auto mb-4 flex items-center justify-center text-4xl">
                    🛣️
                </div>

                <h2 className="text-center text-3xl font-bold text-gray-900">
                    Manage Trips
                </h2>

                <p className="text-center text-gray-600 text-sm mt-2 mb-8">
                    Add route and journey details for your selected bus
                </p>

                <form onSubmit={handleSubmit}>
                    {/* Select Bus */}
                    <div className="mb-4">
                        <label className="block text-sm font-semibold text-gray-800 mb-2">
                            Select Bus
                        </label>

                        <select
                            name="busId"
                            value={tripData.busId}
                            onChange={handleChange}
                            required
                            className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] bg-white outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                        >
                            <option value="">Select bus</option>
                            {buses.map((bus) => (
                                <option key={bus.id} value={bus.id}>
                                    {bus.busName} - {bus.busNumber}
                                </option>
                            ))}
                        </select>
                    </div>

                    {/* From and To */}
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
                        {/* From */}
                        <div className="relative mb-4">
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                From
                            </label>

                            <input
                                type="text"
                                name="from"
                                value={tripData.from}
                                onChange={(e) => {
                                    handleChange(e);
                                    setShowFromSuggestions(true);
                                }}
                                onFocus={() => setShowFromSuggestions(true)}
                                onBlur={() => {
                                    setTimeout(() => setShowFromSuggestions(false), 150);
                                }}
                                placeholder="Enter source city"
                                autoComplete="off"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />

                            {showFromSuggestions && (
                                <div className="absolute top-[78px] left-0 right-0 bg-white border border-gray-300 rounded-md max-h-48 overflow-y-auto z-50 shadow-lg">
                                    {getFilteredCities(tripData.from, tripData.to).length > 0 ? (
                                        getFilteredCities(tripData.from, tripData.to).map((city) => (
                                            <div
                                                key={city}
                                                onMouseDown={() => selectFromCity(city)}
                                                className="px-4 py-3 text-[15px] text-gray-800 cursor-pointer border-b border-gray-100 flex items-center gap-2 hover:bg-[#eef3ff] hover:text-blue-700"
                                            >
                                                <span>📍</span>
                                                <span>{city}</span>
                                            </div>
                                        ))
                                    ) : (
                                        <div className="px-4 py-3 text-sm text-gray-500">
                                            No city found
                                        </div>
                                    )}
                                </div>
                            )}
                        </div>

                        {/* To */}
                        <div className="relative mb-4">
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                To
                            </label>

                            <input
                                type="text"
                                name="to"
                                value={tripData.to}
                                onChange={(e) => {
                                    handleChange(e);
                                    setShowToSuggestions(true);
                                }}
                                onFocus={() => setShowToSuggestions(true)}
                                onBlur={() => {
                                    setTimeout(() => setShowToSuggestions(false), 150);
                                }}
                                placeholder="Enter destination city"
                                autoComplete="off"
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />

                            {showToSuggestions && (
                                <div className="absolute top-[78px] left-0 right-0 bg-white border border-gray-300 rounded-md max-h-48 overflow-y-auto z-50 shadow-lg">
                                    {getFilteredCities(tripData.to, tripData.from).length > 0 ? (
                                        getFilteredCities(tripData.to, tripData.from).map((city) => (
                                            <div
                                                key={city}
                                                onMouseDown={() => selectToCity(city)}
                                                className="px-4 py-3 text-[15px] text-gray-800 cursor-pointer border-b border-gray-100 flex items-center gap-2 hover:bg-[#eef3ff] hover:text-blue-700"
                                            >
                                                <span>📍</span>
                                                <span>{city}</span>
                                            </div>
                                        ))
                                    ) : (
                                        <div className="px-4 py-3 text-sm text-gray-500">
                                            No city found
                                        </div>
                                    )}
                                </div>
                            )}
                        </div>
                    </div>

                    {/* Journey Date */}
                    <div className="mb-4">
                        <label className="block text-sm font-semibold text-gray-800 mb-2">
                            Journey Date
                        </label>

                        <input
                            type="date"
                            name="journeyDate"
                            value={tripData.journeyDate}
                            onChange={handleChange}
                            required
                            className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none cursor-pointer focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                        />
                    </div>

                    {/* Departure and Arrival Time */}
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
                        <div className="mb-4">
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Departure Time
                            </label>

                            <input
                                type="time"
                                name="departureTime"
                                value={tripData.departureTime}
                                onChange={handleChange}
                                onClick={(e) => e.target.showPicker && e.target.showPicker()}
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none cursor-pointer focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>

                        <div className="mb-4">
                            <label className="block text-sm font-semibold text-gray-800 mb-2">
                                Arrival Time
                            </label>

                            <input
                                type="time"
                                name="arrivalTime"
                                value={tripData.arrivalTime}
                                onChange={handleChange}
                                onClick={(e) => e.target.showPicker && e.target.showPicker()}
                                required
                                className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none cursor-pointer focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                            />
                        </div>
                    </div>

                    {/* Price */}
                    <div className="mb-5">
                        <label className="block text-sm font-semibold text-gray-800 mb-2">
                            Price Per Seat
                        </label>

                        <input
                            type="number"
                            name="pricePerSeat"
                            value={tripData.pricePerSeat}
                            onChange={handleChange}
                            placeholder="Enter price per seat"
                            min="1"
                            required
                            className="w-full h-12 px-3 border border-gray-300 rounded-md text-[15px] outline-none focus:border-blue-700 focus:ring-4 focus:ring-blue-100"
                        />
                    </div>

                    <button
                        type="submit"
                        className="w-full h-12 bg-gray-900 text-white rounded-md text-base font-semibold mt-4 hover:bg-blue-700 transition"
                    >
                        Add Trip
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

export default ManageTrips;