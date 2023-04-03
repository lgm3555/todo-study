import * as types from "./constants";

let initState = {
    dKwdDict: {},
    eKwdDict: {},
    dAngDict: {},
    eAngDict: {}
}

export default function reducer(state = initState, actions) {
    switch (actions.type) {
        case types.SET_DANAWA_KWD_DICT:
            return {
                ...state,
                dKwdDict: actions.payload
            }
        case types.SET_ENURI_KWD_DICT:
            return {
                ...state,
                eKwdDict: actions.payload
            }
        case types.SET_DANAWA_ANG_DICT:
            return {
                ...state,
                dAngDict: actions.payload
            }
        case types.SET_ENURI_ANG_DICT:
            return {
                ...state,
                eAngDict: actions.payload
            }
        default:
            return state
    }
}