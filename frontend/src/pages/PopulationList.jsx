import React, { useEffect, useState } from 'react';
import { getAllPopulations } from '../services/populationService';

function PopulationList() {
  const [populations, setPopulations] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    const data = await getAllPopulations();
    setPopulations(data);
  };

  return (
    <div>
      <h1>Population Dashboard</h1>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Country</th>
            <th>Code</th>
            <th>Year</th>
            <th>Population</th>
          </tr>
        </thead>
        <tbody>
          {populations.map((item) => (
            <tr key={item.id}>
              <td>{item.countryName}</td>
              <td>{item.countryCode}</td>
              <td>{item.year}</td>
              <td>{item.value.toLocaleString()}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default PopulationList;