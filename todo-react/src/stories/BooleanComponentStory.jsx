import React from "react";
import { storiesOf } from "@storybook/react";

import StateExample from '../03/03-1'

storiesOf('StateExample', module)
    .add('기본 설정', () => <StateExample />)