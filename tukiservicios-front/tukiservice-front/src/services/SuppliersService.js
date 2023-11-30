export async function getAllSuppliers() {
    const response = await fetch('http://localhost:8080/api/supplier')
    const getData = await response.json();

    return {
        getData
    }
}

export const createNewSupplier = async (supplier) => {
    await fetch(`http://localhost:8080/api/supplier`, {
        body: JSON.stringify(supplier),
        headers: {
            "Content-type": "application/json"
        },
        method: "POST"
    })
};


export const deleteUser = async (id) => {
    await fetch(`http://localhost:8080/api/supplier/${id}`, {
        method: "DELETE"
    })
};