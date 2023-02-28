import React from "react";
import { storiesOf } from "@storybook/react";
import { action } from "@storybook/addon-actions";

import Input from "../04/Input";


storiesOf("Test Input", module)
    .add("base", () => <Input name="name" />)
    .add("label", () => <Input name="name" label="라벨" />)
    .add("onChange", () => (
        <Input name="name" onChange={action("onChange 이벤트")} />
    ));