export async function getAllUsers() {
    const response = await fetch('http://localhost:8080/api/user')
    const getData = await response.json()


    return {
        getData
    }
}


export const createNewUser = async (user) => {
    await fetch(`http://localhost:8080/api/user/create`, {
        body: JSON.stringify(user),
        headers: {
            "Content-type": "application/json"
        },
        method: "POST"
    })
};


export const deleteUser = async (id) => {
    await fetch(`http://localhost:8080/api/user/${id}`, {
        method: "DELETE"
    })
};