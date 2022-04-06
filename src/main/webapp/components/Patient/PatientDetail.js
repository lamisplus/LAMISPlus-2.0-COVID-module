import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import { Link } from 'react-router-dom'
import ButtonMui from "@material-ui/core/Button";
import 'semantic-ui-css/semantic.min.css';
import { Col} from "reactstrap";
import { Grid, Step, Label, Segment, Icon } from "semantic-ui-react";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import PatientCardDetail from './PatientCard'
import { useHistory } from "react-router-dom";

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


function PatientCard(props) {
    let history = useHistory();
    const { classes } = props;
    const patientObj = history.location && history.location.state ? history.location.state.patientObj : {}
    console.log(patientObj)
  return (
    <div className={classes.root}>
      <Card >
        <CardContent>
        <Link to={"/"} >
            <ButtonMui
                variant="contained"
                color="primary"
                className=" float-right mr-1"
                //startIcon={<FaUserPlus size="10"/>}

            >
                <span style={{ textTransform: "capitalize" }}>Back</span>
            </ButtonMui>
            </Link>        
            <br/><br/>
           <PatientCardDetail patientObj={patientObj}/>
            
            {/* Tab Menu  */}
            <Col md={12}>   
            <Step.Group>
                <Step link disabled>
                <Icon name='unordered list' />
                <Step.Content>
                    <Step.Title>History</Step.Title>
                    <Step.Description>Patient Clinical History</Step.Description>
                </Step.Content>
                </Step>
                <Step link>
                <Icon name='bed' />
                <Step.Content>
                    <Step.Title>Vaccination</Step.Title>
                    <Step.Description>Enter patient vaccination</Step.Description>
                </Step.Content>
                </Step>
                <Step link>
                <Icon name='bed' />
                <Step.Content>
                    <Step.Title>Admission</Step.Title>
                    <Step.Description> Admission information</Step.Description>
                </Step.Content>
                </Step>
                <Step link disabled>
                <Icon name='stethoscope' />
                <Step.Content>
                    <Step.Title>ICU</Step.Title>
                    <Step.Description>Enter patient ICU information</Step.Description>
                </Step.Content>
                </Step>
                <Step link disabled>
                <Icon name='magic' />
                <Step.Content>
                    <Step.Title>Discharge/Dead</Step.Title>
                    <Step.Description>Update patient status </Step.Description>
                </Step.Content>
                </Step>
            </Step.Group>
            </Col>
            {/* End of Tab Menu */}
            <br/>
            {/* Sematic Ui Card */}
            <Grid centered columns={2} padded>
                <Grid.Column>
                <Segment raised>
                <Label as='a' color='blue' ribbon>
                        INCLUSION CRITERIA 
                        
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/>
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='orange' ribbon='left'>
                        DEMOGRAPHICS 
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/>
                </Segment>
                </Grid.Column>
                <Grid.Column>
                <Segment raised>
                    <Label as='a' color='brown' ribbon>
                    VACCINATION 
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/>
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='pink' ribbon='left'>
                        VITAL SIGNS 
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/>
                </Segment>
                </Grid.Column>
                <Grid.Column>
                <Segment raised>
                    <Label as='a' color='purple' ribbon>
                    CO-MORBIDITIE
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/> 
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='violet' ribbon='left'>
                    REINFECTION
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/>
                </Segment>
                </Grid.Column>
                <Grid.Column>
                <Segment raised>
                    <Label as='a' color='teal' ribbon>
                    SIGNS AND SYMPTOMS
                    <Icon name='plus' size='small' className=" float-right mr-1"/>
                    </Label>
                    
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='green' ribbon='left'>
                    CHRONIC MEDICATION 
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/>
                </Segment>
                </Grid.Column>
                <Grid.Column>
                <Segment raised>
                    <Label as='a' color='olive' ribbon>
                    MEDICATION  
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/>  
                </Segment>
                </Grid.Column>

                <Grid.Column>
                <Segment>
                    <Label as='a' color='yellow' ribbon='left'>
                    SUPPORTIVE CARE 
                    </Label>
                    <Icon name='plus' size='small' className=" float-right mr-1"/>
                </Segment>
                </Grid.Column>
            </Grid>

         </CardContent>
      </Card>
    </div>
  );
}

PatientCard.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(PatientCard);
