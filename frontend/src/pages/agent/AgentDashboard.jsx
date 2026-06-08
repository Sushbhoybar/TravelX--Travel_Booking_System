import { useNavigate } from "react-router-dom";

function AgentDashboard() {
    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("userRole");

        alert("Logged out successfully");
        navigate("/login");
    };

    const dashboardCards = [
        {
            title: "Add Bus",
            icon: "🚌",
            description: "Add new bus details, bus number, type, seats and layout.",
            buttonText: "Add Bus",
            path: "/agent/add-bus",
        },
        {
            title: "Manage Routes",
            icon: "🛣️",
            description: "Create trips by adding route, date, time and fare details.",
            buttonText: "Manage Routes",
            path: "/agent/manage-routes",
        },
        {
            title: "View Bookings",
            icon: "🎟️",
            description: "View booked passengers, seat numbers and booking details.",
            buttonText: "View Bookings",
            path: "/agent/view-bookings",
        },
        {
            title: "Bus Status",
            icon: "📍",
            description: "Update bus running status, delay information and trip status.",
            buttonText: "Bus Status",
            path: "/agent/bus-status",
        },
    ];

    return (
        <div className="min-h-screen bg-[#f5f7fb] px-5 py-8 font-sans">
            <div className="max-w-7xl mx-auto">
                {/* Header */}
                <div className="bg-white border border-gray-300 rounded-xl shadow-md px-8 py-6 mb-8 flex flex-col md:flex-row md:items-center md:justify-between gap-5">
                    <div>
                        <h2 className="text-3xl font-bold text-gray-900">
                            Agent Dashboard
                        </h2>
                        <p className="text-gray-600 mt-2">
                            Welcome back, Agent! Manage your buses, trips and bookings here.
                        </p>
                    </div>

                    <button
                        onClick={handleLogout}
                        className="bg-red-600 text-white px-6 py-3 rounded-md font-semibold hover:bg-red-700 transition"
                    >
                        Logout
                    </button>
                </div>

                {/* Small Stats Section */}
                <div className="grid grid-cols-1 lg:grid-cols-3 gap-5 mb-8">
                    <div className="bg-white border border-gray-300 rounded-xl shadow-sm p-5">
                        <p className="text-gray-500 text-sm font-medium">Total Buses</p>
                        <h3 className="text-3xl font-bold text-gray-900 mt-2">12</h3>
                    </div>

                    <div className="bg-white border border-gray-300 rounded-xl shadow-sm p-5">
                        <p className="text-gray-500 text-sm font-medium">Active Trips</p>
                        <h3 className="text-3xl font-bold text-gray-900 mt-2">8</h3>
                    </div>

                    <div className="bg-white border border-gray-300 rounded-xl shadow-sm p-5">
                        <p className="text-gray-500 text-sm font-medium">Bookings</p>
                        <h3 className="text-3xl font-bold text-gray-900 mt-2">156</h3>
                    </div>
                </div>

                {/* Dashboard Cards */}
                <div className="grid grid-cols-1 lg:grid-cols-4 gap-6">
                    {dashboardCards.map((card) => (
                        <div
                            key={card.title}
                            onClick={() => navigate(card.path)}
                            className="bg-white border border-gray-300 rounded-xl shadow-md p-6 text-center cursor-pointer hover:-translate-y-1 hover:shadow-lg transition"
                        >
                            <div className="w-[75px] h-[75px] bg-[#eef3ff] text-[#1d4ed8] rounded-full mx-auto mb-4 flex items-center justify-center text-4xl">
                                {card.icon}
                            </div>

                            <h3 className="text-xl font-bold text-gray-900 mb-3">
                                {card.title}
                            </h3>

                            <p className="text-gray-600 text-sm leading-6 min-h-[72px] mb-5">
                                {card.description}
                            </p>

                            <button
                                onClick={(e) => {
                                    e.stopPropagation();
                                    navigate(card.path);
                                }}
                                className="w-full h-11 bg-gray-900 text-white rounded-md font-semibold hover:bg-blue-700 transition"
                            >
                                {card.buttonText}
                            </button>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

export default AgentDashboard;