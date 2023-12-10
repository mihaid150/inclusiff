import axios from 'axios'

function useTrainings() {
    const getTrainings = async () => {
        const response = await axios.get('http://localhost:10004/trainings')
        if (response.status === 200) {
            return response.data
        } else {
            console.error("Error getting trainings!")
        }
    }

    return { getTrainings };
}

export default useTrainings;