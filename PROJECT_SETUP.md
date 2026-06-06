# TravelX Frontend Setup Guide
# Frontend Structure

```text
travelx-bus-booking-system/
│
└── frontend/
    │
    ├── public/
    │
    ├── src/
    │   │
    │   ├── assets/
    │   │   ├── images/
    │   │   └── icons/
    │   │
    │   ├── components/
    │   │
    │   ├── layouts/
    │   │
    │   ├── pages/
    │   │   ├── customer/
    │   │   ├── agent/
    │   │   └── admin/
    │   │
    │   ├── routes/
    │   │
    │   ├── styles/
    │   │
    │   ├── App.jsx
    │   └── main.jsx
    │
    ├── package.json
    └── README.md
```


## Prerequisites

Install:

* Node.js (v18 or later)
* Git
* VS Code

Verify installation:

```bash
node -v
npm -v
git --version
```

---

## Clone Repository

```bash
git clone <repository-url>
```

```bash
cd travelx-bus-booking-system/frontend
```

---

## Install Dependencies

```bash
npm install
```

---

## Start Development Server

```bash
npm run dev
```

Default URL:

```text
http://localhost:5173
```

---

## Required Packages

```bash
npm install react-router-dom
npm install axios
npm install react-icons
npm install bootstrap
npm install tailwindcss @tailwindcss/vite
```

---

## Pull Latest Changes

```bash
git pull origin main
```

---

## Push Changes

```bash
git add .
git commit -m "Added Customer Login UI"
git push origin feature-page-name
```

---
