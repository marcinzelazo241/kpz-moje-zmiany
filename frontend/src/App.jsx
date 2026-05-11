import React, { useEffect, useState } from 'react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer } from 'recharts';
import axios from 'axios';
import './App.css';

function App() {
  const [jobs, setJobs] = useState([]);
  const [loading, setLoading] = useState(false);

  const coverageData = [
    { name: 'Build #1', coverage: 65 },
    { name: 'Build #2', coverage: 62 },
    { name: 'Build #3', coverage: 78 },
    { name: 'Build #4', coverage: 75 },
    { name: 'Build #5', coverage: 82 },
  ];

  const fetchJobs = () => {
    setLoading(true);
    axios.get('http://localhost:8082/api/jenkins/getJobs')
      .then(res => {
        setJobs(res.data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Backend nie odpowiada, ale to nic!");
        setLoading(false);
      });
  };

  useEffect(() => {
    fetchJobs();
  }, []);

  return (
    <div style={{ backgroundColor: '#121212', color: 'white', minHeight: '100vh', padding: '20px', fontFamily: 'sans-serif' }}>
      <h1 style={{ color: '#00ff88' }}>🚀 Flaky Test Coach</h1>
      
      {/* SEKCJA WYKRESU */}
      <div style={{ backgroundColor: '#1e1e1e', padding: '20px', borderRadius: '10px', marginBottom: '20px' }}>
        <h3>📈 Test Coverage Trend</h3>
        <div style={{ width: '100%', height: 300 }}>
          <ResponsiveContainer width="100%" height="100%">
            <LineChart data={coverageData}>
              <CartesianGrid strokeDasharray="3 3" stroke="#444" />
              <XAxis dataKey="name" stroke="#888" />
              <YAxis stroke="#888" unit="%" />
              <Tooltip contentStyle={{ backgroundColor: '#222', border: 'none' }} />
              <Line type="monotone" dataKey="coverage" stroke="#00ff88" strokeWidth={3} />
            </LineChart>
          </ResponsiveContainer>
        </div>
      </div>

      {/* SEKCJA TABELI */}
      <table style={{ width: '100%', borderCollapse: 'collapse' }}>
        <thead>
          <tr style={{ borderBottom: '1px solid #444', textAlign: 'left' }}>
            <th style={{ padding: '10px' }}>Zadanie</th>
            <th style={{ padding: '10px' }}>Status</th>
          </tr>
        </thead>
        <tbody>
          {jobs.length > 0 ? jobs.map(job => (
            <tr key={job.name} style={{ borderBottom: '1px solid #222' }}>
              <td style={{ padding: '10px' }}>{job.name}</td>
              <td style={{ padding: '10px' }}>{job.lastBuild?.result || 'PENDING'}</td>
            </tr>
          )) : (
            <tr><td colSpan="2" style={{ padding: '20px', color: '#666' }}>Czekam na dane z backendu...</td></tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default App;