import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [jobs, setJobs] = useState([]);
  const [loading, setLoading] = useState(false);

  // 1. Funkcja pobierająca dane
  const fetchJobs = () => {
    setLoading(true);
    axios.get('http://localhost:8082/api/jenkins/getJobs')
      .then(response => {
        setJobs(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error("Błąd pobierania:", error);
        setLoading(false);
      });
  };

  // 2. Funkcja uruchamiająca zadanie (TEGO BRAKOWAŁO!)
  const runJob = (name) => {
    axios.post(`http://localhost:8082/api/jenkins/run/${name}`)
      .then(() => {
        alert(`Zadanie ${name} zostało uruchomione!`);
        fetchJobs(); // Odśwież od razu po kliknięciu
      })
      .catch(err => {
        console.error("Błąd uruchamiania:", err);
        alert("Nie udało się uruchomić zadania.");
      });
  };

  // 3. Automatyczne odświeżanie co 5 sekund
  useEffect(() => {
    fetchJobs();
    const interval = setInterval(() => {
      fetchJobs();
    }, 5000);
    return () => clearInterval(interval);
  }, []);

  return (
    <div className="dashboard-container">
      <header>
        <h1>
  🚀 Flaky Test & Coverage Coach 
  <span className={`refresh-indicator ${loading ? 'visible' : 'hidden'}`}>
    ● SYNC
  </span>
</h1>
        <button className="refresh-btn" onClick={fetchJobs}>Odśwież ręcznie</button>
      </header>

      <div className="table-wrapper">
        <table className="job-table">
          <thead>
            <tr>
              <th>Status</th>
              <th>Nazwa zadania</th>
              <th>Ostatni Build</th>
              <th>Akcja</th>
            </tr>
          </thead>
          <tbody>
            {jobs.map((job) => (
              <tr key={job.name}>
                <td>
                  <span className={`status-dot ${job.lastBuild?.result === 'SUCCESS' ? 'green' : 'red'}`}></span>
                  <span className="status-text">{job.lastBuild?.result || 'PENDING'}</span>
                </td>
                <td className="job-name">{job.name}</td>
                <td>#{job.lastBuild?.number || '---'}</td>
                <td>
                  <button className="run-btn" onClick={() => runJob(job.name)}>
                    ▶ Uruchom
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default App;
