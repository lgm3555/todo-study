import {applyMiddleware, createStore} from 'redux';
import dictReducer from './dictReducers';
import ReduxThunk from "redux-thunk";

const store = createStore(
    dictReducer,
    applyMiddleware(
        ReduxThunk,
    )
);

export default store;