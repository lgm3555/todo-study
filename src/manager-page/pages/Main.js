import React from "react";
import Tab from "@mui/material/Tab";
import Tabs from "@material-ui/core/Tabs";
import {makeStyles} from "@material-ui/core/styles";
import DictTable from "../components/pages/DictTable";
import {Grid} from "@material-ui/core";
import SearchBar from "../components/pages/SearchBar";
import {getDanawaDictData, getEnuriDictData} from "../services/DictService";

const useStyles = makeStyles((theme) => ({
    root: {
        height: "100vh",
        backgroundColor: theme.palette.background.paper,
        display: 'flex',
    },
    tabs: {
        borderRight: `1px solid ${theme.palette.divider}`,
        width: '190px',
    },
    search: {
        height: "140px",
        paddingTop: "40px",
    },
    table: {
        borderRight: `1px solid ${theme.palette.divider}`,
    }
}));

function Main() {
    const classes = useStyles();
    const [value, setValue] = React.useState(0);
    const [danawaDict, setDanawaDict] = React.useState({});
    const [enuriDict, setEnuriDict] = React.useState({});

    const handleChange = (event, newValue) => {
        setValue(newValue);
        setDanawaDict(getDanawaDictData(newValue));
        setEnuriDict(getEnuriDictData(newValue));
    };

    return (
        <div className={classes.root}>
            <Tabs
                orientation="vertical"
                variant="scrollable"
                value={value}
                onChange={handleChange}
                className={classes.tabs}
            >
                <Tab label="키워드 사전" />
                <Tab label="유사어 사전" />
            </Tabs>
            <Grid container>
                <Grid item xs={12} className={classes.search}>
                    <SearchBar />
                </Grid>
                <Grid item xs={6} className={classes.table}>
                    <DictTable type="danawa" dictType={value} data={danawaDict} />
                </Grid>
                <Grid item xs={6}>
                    <DictTable type="enuri" dictType={value} data={enuriDict} />
                </Grid>
            </Grid>
        </div>
    );
}

export default Main;
