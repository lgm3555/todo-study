import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import Container from '@mui/material/Container';
import {createTheme, ThemeProvider} from '@mui/material/styles';
import MainFeaturedPost from '../components/pages/MainFeaturedPost';
import CheckPost from '../components/pages/CheckPost';
import Header from "../components/layout/Header";
import {TabContext, TabPanel} from "@mui/lab";
import Box from "@mui/material/Box";
import {check} from "../services/AuthService";
import {productCategory} from "../services/ProductService";

const sections = [
    { title: '인기상품', value: '0' },
    { title: '상의', value: '1' },
    { title: '하의', value: '2' },
    { title: '셔츠', value: '3' },
    { title: '니트', value: '4' },
    { title: '신발', value: '5' },
    { title: '악세사리', value: '6' },
];

const theme = createTheme();

export default function Main() {

    const [status, setStatus] = React.useState(false);
    const [value, setValue] = React.useState('0');
    const [featuredPost, setFeaturedPost] = React.useState([]);

    React.useEffect(() => {
        check().then(res => {
            let active = (res || {}).data;
            if (active === 'active') {
                setStatus(true)
            } else {
                setStatus(false)
            }
        })
    }, [])

    React.useEffect(() => {
        productCategory(value).then(res => {
            setFeaturedPost(res.data)
        })
    }, [value])

    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <Container sx={{maxWidth: '85%'}} maxWidth={false}>
                <TabContext value={value}>
                    <Header name='main' sections={sections} status={status} setValue={setValue} />
                    <Box
                        gap={20}
                        sx={{
                            borderTop: 1,
                            borderColor: 'divider',
                            display: 'flex',
                            justifyContent: 'center',
                        }}
                    >
                        <TabPanel value={value}>
                            {
                                value == 0 ?
                                    <MainFeaturedPost />
                                    :
                                    ''
                            }
                            <Grid container spacing={1}>
                                {featuredPost.map((post, key) => (
                                    <CheckPost key={key} post={post} />
                                ))}
                            </Grid>
                        </TabPanel>
                    </Box>
                </TabContext>
            </Container>
        </ThemeProvider>
    );
}