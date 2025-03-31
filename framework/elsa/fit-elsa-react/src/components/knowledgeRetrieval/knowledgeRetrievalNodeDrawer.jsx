/*---------------------------------------------------------------------------------------------
 *  Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 *  This file is a part of the ModelEngine Project.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

import {jadeNodeDrawer} from '@/components/base/jadeNodeDrawer.jsx';
import RetrievalIcon from '../asserts/icon-retrieval.svg?react';

/**
 * 检索节点绘制器
 *
 * @override
 */
export const knowledgeRetrievalNodeDrawer = (shape, div, x, y) => {
    const self = jadeNodeDrawer(shape, div, x, y);
    self.type = 'knowledgeRetrievalNodeDrawer';

    /**
     * @override
     */
    self.getHeaderIcon = () => {
        return (<>
            <RetrievalIcon className='jade-node-custom-header-icon'/>
        </>);
    };

    return self;
};