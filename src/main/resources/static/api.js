// Vendos URL bazë për API
const API_BASE_URL = "http://localhost:8081/api";

// Funksioni për marrjen e token-it nga localStorage
function getToken() {
    const token = localStorage.getItem("token");
    if (!token) {
        console.warn("Token nuk u gjet në localStorage. Përdoruesi nuk është autentifikuar.");
    }
    return token;
}

// Funksioni për thirrje të API me autentifikim
async function fetchWithAuth(endpoint, options = {}) {
    const token = getToken();

    if (!token) {
        throw new Error("Përdoruesi nuk është autentifikuar. Ju lutem hyni.");
    }

    const headers = options.headers || {};
    headers["Authorization"] = `Bearer ${token}`;
    headers["Content-Type"] = "application/json";

    const response = await fetch(`${API_BASE_URL}${endpoint}`, {
        ...options,
        headers,
    });

    if (!response.ok) {
        if (response.status === 401) {
            alert("Sesioni juaj ka skaduar. Ju lutem hyni përsëri.");
            window.location.href = "login.html";
        }
        throw new Error(`Gabim nga API: ${response.status}`);
    }

    return response.json();
}

// Funksion për autentifikim (Login)
async function loginUser(credentials) {
    const response = await fetch(`${API_BASE_URL}/auth/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(credentials),
    });

    if (!response.ok) {
        throw new Error("Gabim gjatë loginit. Ju lutem kontrolloni kredencialet.");
    }

    const data = await response.json();
    // Ruaj tokenin në localStorage
    localStorage.setItem("token", data.token);
    return data;
}

// Funksion për regjistrim
async function registerUser(userData) {
    const response = await fetch(`${API_BASE_URL}/auth/register`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(userData),
    });

    if (!response.ok) {
        throw new Error("Gabim gjatë regjistrimit. Ju lutem provoni përsëri.");
    }

    return response.json();
}

// Funksion për marrjen e listës së parfumeve
async function getPerfumes() {
    return await fetchWithAuth("/perfumes");
}

// Funksion për marrjen e parfumit sipas ID-së
async function getPerfumeById(id) {
    return await fetchWithAuth(`/perfumes/${id}`);
}

// Funksion për marrjen e parfumeve sipas brendit
async function getPerfumesByBrand(brand) {
    return await fetchWithAuth(`/perfumes/brand/${brand}`);
}

// Funksion për shtimin e parfumit (vetëm për admin)
async function addPerfume(perfumeData) {
    return await fetchWithAuth("/perfumes", {
        method: "POST",
        body: JSON.stringify(perfumeData),
    });
}

// Funksion për përditësimin e parfumit (vetëm për admin)
async function updatePerfume(id, perfumeData) {
    return await fetchWithAuth(`/perfumes/${id}`, {
        method: "PUT",
        body: JSON.stringify(perfumeData),
    });
}

// Funksion për fshirjen e parfumit (vetëm për admin)
async function deletePerfume(id) {
    return await fetchWithAuth(`/perfumes/${id}`, {
        method: "DELETE",
    });
}

// Funksion për marrjen e të gjithë përdoruesve (vetëm për admin)
async function getUsers() {
    return await fetchWithAuth("/users");
}

// Funksion për përditësimin e përdoruesve
async function updateUser(username, userData) {
    return await fetchWithAuth(`/users/${username}`, {
        method: "PUT",
        body: JSON.stringify(userData),
    });
}

// Funksion për fshirjen e përdoruesve
async function deleteUser(username) {
    return await fetchWithAuth(`/users/${username}`, {
        method: "DELETE",
    });
}

// Funksion për logout
function logoutUser() {
    localStorage.removeItem("token");
    window.location.href = "login.html";
}
