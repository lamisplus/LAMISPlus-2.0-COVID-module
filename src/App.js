import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import RegisterPatient from './main/webapp/components/Patient/RegisterPatient'
import EditPatient from './main/webapp/components/Patient/EditPatient'
import Home from './main/webapp/components/Home'
import PatientDetail from './main/webapp/components/Patient/PatientDetail'
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
            <RegisterPatient />
          </Route>
          <Route path="/patient-dashboard">
            <PatientDetail />
          </Route>
          <Route path="/edit-patient">
            <EditPatient />
          </Route>
          <Route path="/">
            <Home />
          </Route>
        
          
        </Switch>
      </div>
    </Router>
  );
}

// function RegisterPatientPage() {
//   return <RegisterPatient />;
// }
// function Patient() {
//   return <PatientDetail />;
// }


