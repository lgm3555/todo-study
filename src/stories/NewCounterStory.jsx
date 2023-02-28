import React from 'react';
import { storiesOf } from '@storybook/react';

import NewCouter from '../04/04-2';

storiesOf('NewCounter', module).add('기본 설정', () => <NewCouter count={3} />);