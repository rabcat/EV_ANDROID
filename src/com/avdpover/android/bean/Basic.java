package com.avdpover.android.bean;

import com.avdpower.android.utilities.DESUtil;

public class Basic extends avd_message_base_bean {
	/*
	 * 0 ֡ͷ1 1 ֡ͷ2 2 ����ѹ���ֽ� �޷���16λ�� ��λ���� 3 ����ѹ���ֽ� 4 ����ѹ�ָ����ֽ� 5 ����ѹ�ָ����ֽ� 6 Ƿ��ѹ���ֽ�
	 * 7 Ƿ��ѹ���ֽ� 8 Ƿ��ѹ�ָ����ֽ� 9 Ƿ��ѹ�ָ����ֽ� 10 ����������������������ֽ� �޷���16λ��, ��λ������ 11
	 * ����������������������ֽ� 12 ������ֱ�������趨 �޷���8λ���� ��λ������ 13 ���ٵ����ٵ��ֽ� �޷���16λ�� ��λ��rpm 14
	 * ���ٵ����ٸ��ֽ� 15 ת����Ч�ͷ�ֵ���ֽ� �޷���16λ�� ��λ��0.0001V 16 ת����Ч�ͷ�ֵ���ֽ� 17 ת����Ч�߷�ֵ���ֽ� 18
	 * ת����Ч�߷�ֵ���ֽ� 19 ��Ť������ת�ѵ�λ���ֽ� 20 ��Ť������ת�ѵ�λ���ֽ� 21 ���ٵ����ٵ��ֽ� �޷���16λ�� ��λ��rpm 22
	 * ���ٵ����ٸ��ֽ� 23 ֡β
	 */

	public int DC_current;
	public int Phase_current;
	public float High_voltage;
	public float High_voltage_revocer;
	public float Low_voltage;
	public float Low_voltage_recover;
	public float Throttle_low;
	public float Throttle_mid;
	public float Throttle_high;
	public int Max_speed;
	public int ECO_speed;

	// public byte [] bytes;

	public Basic(byte[] bytes) {
	
		initial(bytes);
	}
	public Basic()
	{
		
	}
	
	public void initial(byte[] bytes)
	{
		store_inner_bytes(bytes);
		start1 = bytes[0];
		start2 = bytes[1];

		DC_current = DESUtil.bytesToUnSignInt8(bytes[12]);
		Phase_current = DESUtil.bytesToUnSignInt16(bytes[10], bytes[11]);
		High_voltage = ((float)DESUtil.bytesToUnSignInt16(bytes[2], bytes[3]))/100;
		High_voltage_revocer = ((float)DESUtil.bytesToUnSignInt16(bytes[4], bytes[5]))/100;
		Low_voltage=((float)DESUtil.bytesToUnSignInt16(bytes[6], bytes[7]))/100;
		Low_voltage_recover=((float)DESUtil.bytesToUnSignInt16(bytes[8], bytes[9]))/100;
		
		Throttle_low=((float)DESUtil.bytesToUnSignInt16(bytes[13], bytes[14]))/1000;
		Throttle_mid=((float)DESUtil.bytesToUnSignInt16(bytes[15], bytes[16]))/1000;
		Throttle_high=((float)DESUtil.bytesToUnSignInt16(bytes[17], bytes[18]))/1000;
		
		Max_speed= DESUtil.bytesToUnSignInt16(bytes[19], bytes[20]);
		ECO_speed= DESUtil.bytesToUnSignInt16(bytes[21], bytes[22]);
		
		end=bytes[23];
	}

}
