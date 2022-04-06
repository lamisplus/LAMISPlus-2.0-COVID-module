import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import RegisterPatient from './main/webapp/components/RegisterPatient'
import Dashboard from './main/webapp/components/PatientList'
import Home from './main/webapp/components/Home'
import PatientDetail from './main/webapp/components/PatientDetail'
import { ToastContainer} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export default function App() {
  return (
    <Router>
      <div>
      <ToastContainer />
        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
         
          <Route path="/register-patient">
            <RegisterPatientPage />
          </Route>
          <Route path="/patient-detail">
            <PatientDetail />
          </Route>
          <Route path="/">
          <Home />
          </Route>
        
          
        </Switch>
      </div>
    </Router>
  );
}

function PatientDashboard() {
  return <Dashboard />;
}
function RegisterPatientPage() {
  return <RegisterPatient />;
}
// function Patient() {
//   return <PatientDetail />;
// }


