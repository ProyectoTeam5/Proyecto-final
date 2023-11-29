export async function getAllSuppliers() {
    const response = await fetch('http://localhost:8080/api/supplier')
    console.log(response);
}