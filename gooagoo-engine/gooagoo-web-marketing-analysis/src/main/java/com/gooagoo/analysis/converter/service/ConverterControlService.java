package com.gooagoo.analysis.converter.service;

import java.util.List;

import com.gooagoo.analysis.entity.Behave;

/**
 * 
 * @author YL
 *
 */
public interface ConverterControlService
{
    public List<Behave> getBehave(Object obj) throws Exception;

}
