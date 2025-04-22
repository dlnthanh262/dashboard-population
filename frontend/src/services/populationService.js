import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/populations';

export const getAllPopulations = async () => {
  const response = await axios.get(API_BASE_URL);
  return response.data;
};

export const deletePopulation = async (id) => {
  return await axios.delete(`${API_BASE_URL}/${id}`);
};

export const createPopulation = async (data) => {
  return await axios.post(API_BASE_URL, data);
};

export const updatePopulation = async (id, data) => {
  return await axios.put(`${API_BASE_URL}/${id}`, data);
};