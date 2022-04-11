import React,{useState, useEffect} from 'react';
//import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
//import { Link } from 'react-router-dom'
//import ButtonMui from "@material-ui/core/Button";
import 'semantic-ui-css/semantic.min.css';
import axios from "axios";

import { url as baseUrl } from "./../../../api";
import { token as token } from "./../../../api";
import { Grid,  Label, Segment, Icon, List, Button, Image } from "semantic-ui-react";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import { useHistory } from "react-router-dom";
//import {  Button } from "react-bootstrap";
import InclusionCriteria from './InclusionCriteria';
import Demographic from './Demograhic';
import Viccination from './Vaccination';
import  Comorbitie from './Comorbitie';
import  VitalSign from './VitalSign';
import  ReInfection from './ReInfection';
import ChronicMedication from './ChronicMedication';
import  Medication from './Medication';
import  SignsSymptoms from './SignsSymptons';
import  SupportiveCare from './SupportiveCare';

const styles = theme => ({
  root: {
    width: '100%',
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
  },
  secondaryHeading: {
    fontSize: theme.typography.pxToRem(15),
    color: theme.palette.text.secondary,
  },
  icon: {
    verticalAlign: 'bottom',
    height: 20,
    width: 20,
  },
  details: {
    alignItems: 'center',
  },
  column: {
    flexBasis: '20.33%',
  },
  helper: {
    borderLeft: `2px solid ${theme.palette.divider}`,
    padding: `${theme.spacing.unit}px ${theme.spacing.unit * 2}px`,
  },
  link: {
    color: theme.palette.primary.main,
    textDecoration: 'none',
    '&:hover': {
      textDecoration: 'underline',
    },
  },
});

let resultData=""

function AddmissionHome(props) {
    let history = useHistory();
    const { classes } = props;
    const patientObjValue = history.location && history.location.state ? history.location.state.patientObj : {}
    const [patientObj, setpatientObj] = useState(patientObjValue)
    const [inclusionCriteriaModal, setInclusionCriteriaModal] = useState(false);
    const inclusionCriteriaToggle = () => setInclusionCriteriaModal(!inclusionCriteriaModal);
    const [demographicModal, setDemographicModal] = useState(false);
    const demographicToggle = () => setDemographicModal(!demographicModal);
    const [viccinationModal, setViccinationModal] = useState(false);
    const ViccinationToggle = () => setViccinationModal(!viccinationModal);
    const [comorbitieModal, setComorbitieModal] = useState(false);
    const ComorbitieToggle = () => setComorbitieModal(!comorbitieModal);
    const [vitalSignModal, setVitalSignModal] = useState(false);
    const VitalSignToggle = () => setVitalSignModal(!vitalSignModal);
    const [reInfectionModal, setReinfectionModal] = useState(false);
    const ReinfectionToggle = () => setReinfectionModal(!reInfectionModal);
    const [signsSymptomsModal, setSignsSymptomsModal] = useState(false);
    const SignsSymptomsToggle = () => setSignsSymptomsModal(!signsSymptomsModal);
    const [medicationModal, setMedicationModal] = useState(false);
    const MedicationToggle = () => setMedicationModal(!medicationModal);
    const [chronicMedicationModal, setChronicMedicationModal] = useState(false);
    const ChronicMedicationToggle = () => setChronicMedicationModal(!chronicMedicationModal);
    const [supportiveCareModal, setSupportiveCareModal] = useState(false);
    const SupportiveCareToggle = () => setSupportiveCareModal(!supportiveCareModal);

    const loadInclusionCriteriaModal =()=> {
          setInclusionCriteriaModal(!inclusionCriteriaModal)
    }
    const DemographicModal =()=> {
      setDemographicModal(!demographicModal)
    }
    const ViccinationModal =()=> {
      setViccinationModal(!viccinationModal)
    }
    const VitalSignModal =()=> {
      setVitalSignModal(!vitalSignModal)
    }
    const ComorbitieModal =()=> {
      setComorbitieModal(!comorbitieModal)
    }
    const ReInfectionModal =()=> {
      setReinfectionModal(!reInfectionModal)
    }
    const SignsSymptomsModal =()=> {
      setSignsSymptomsModal(!signsSymptomsModal)
    }
    const ChronicMedicationModal =()=> {
      setChronicMedicationModal(!chronicMedicationModal)
    }
    const MedicationModal =()=> {
      setMedicationModal(!medicationModal)
    }
    const SupportiveCareModal =()=> {
      setSupportiveCareModal(!supportiveCareModal)
    }
    useEffect(() => {
      getAdmissionCategory()
    },[])
    const getAdmissionCategory = (category) => {
      axios
        .get(`${baseUrl}covid/encounters/1/VACCINATION_STATUS`,
        { headers: {"Authorization" : `Bearer ${token}`} }
        )
        .then((response) => {
          resultData=response.data
            //setVaccination(response.data);
            //setValues(response.data)
        })
        .catch((error) => {    
        }); 
        //return resultData
    }
  console.log(resultData)


  return (
    <div className={classes.root}>
      <Card >
        <CardContent>
       
            {/* Sematic Ui Card */}
            <Grid centered columns={2} padded>
                <Grid.Column>
                <Segment raised>
                <Label as='a' color='blue'  ribbon>
                        INCLUSION CRITERIA 
                        
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() =>loadInclusionCriteriaModal()}/>
                    <List divided verticalAlign='middle'>
                    {resultData!=="" && resultData.map((value) => (
                          <>
                          
                            <List.Item>
                              <List.Content floated='right'>
                              <Label>
                                View
                              </Label>
                              </List.Content>
                              <Icon name='info circle'  />
                              <List.Content>Lena</List.Content>
                            </List.Item>
                          </>
                    ))
                    }
                    </List>
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='orange' ribbon='left'>
                        DEMOGRAPHICS 
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() => DemographicModal()}/>
                </Segment>
                </Grid.Column>
                <Grid.Column>
                <Segment raised>
                    <Label as='a' color='brown' ribbon>
                    VACCINATION 
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() => ViccinationModal()}/>

                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='pink' ribbon='left'>
                        VITAL SIGNS 
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() => VitalSignModal()}/>
                </Segment>
                </Grid.Column>
                <Grid.Column>
                <Segment raised>
                    <Label as='a' color='purple' ribbon>
                    CO-MORBIDITIE
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() => ComorbitieModal()}/> 
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='violet' ribbon='left'>
                    REINFECTION
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() => ReInfectionModal()}/>
                </Segment>
                </Grid.Column>
                <Grid.Column>
                <Segment raised>
                    <Label as='a' color='teal' ribbon>
                    SIGNS AND SYMPTOMS
                   
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() => SignsSymptomsModal()}/>
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='green' ribbon='left'>
                    CHRONIC MEDICATION 
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() => ChronicMedicationModal()}/>
                </Segment>
                </Grid.Column>
                <Grid.Column>
                <Segment raised>
                    <Label as='a' color='olive' ribbon>
                    MEDICATION  
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1" style={{cursor: 'pointer'}} onClick={() => MedicationModal()}/>
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='yellow' ribbon='left'>
                    SUPPORTIVE CARE 
                    </Label>
                    <Icon name='plus' size='small' className=" float-end ms-1"  style={{cursor: 'pointer'}} onClick={() => SupportiveCareModal()}/>
                </Segment>
                </Grid.Column>
            </Grid>

         </CardContent>
      </Card>

      <InclusionCriteria toggle={inclusionCriteriaToggle} showModal={inclusionCriteriaModal} patientObj={patientObj}/>
      <Demographic toggle={demographicToggle} showModal={demographicModal} patientObj={patientObj} />
      <Viccination toggle={ViccinationToggle} showModal={viccinationModal} patientObj={patientObj} />
      <VitalSign toggle={VitalSignToggle} showModal={vitalSignModal} patientObj={patientObj} />
      <Comorbitie toggle={ComorbitieToggle} showModal={comorbitieModal} patientObj={patientObj} />
      <ReInfection toggle={ReinfectionToggle} showModal={reInfectionModal} patientObj={patientObj} />
      <ChronicMedication toggle={ChronicMedicationToggle} showModal={chronicMedicationModal} patientObj={patientObj} />
      <Medication toggle={MedicationToggle} showModal={medicationModal} patientObj={patientObj} />
      <SignsSymptoms toggle={SignsSymptomsToggle} showModal={signsSymptomsModal} patientObj={patientObj} />
      <SupportiveCare toggle={SupportiveCareToggle} showModal={supportiveCareModal} patientObj={patientObj} />
    </div>
  );
}



export default withStyles(styles)(AddmissionHome);
