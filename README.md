commonlibrary
=============

OS X�̕����R�[�h���

�����F OS X, JDK7�ȏ�
�Ǐ�FFile�N���X���g�����v���O�����ŁC���{��t�@�C�����C�t�H���_���̂��̂������Ȃ��D
�iexists()���\�b�h��false��Ԃ��j

���ׂ��T�C�g�F
OS X��Java 7�ł�File�Ƀo�O������y�Ǝv���Ă����z
http://qiita.com/ripplestep/items/fbdd5765a64a00be6410
http://piyopiyoducky.net/blog/2013/06/03/encoding-of-java-application-in-os-x/

�����F
�Esun.jnu.encoding��file.encoding�Ɠ��l�Ɋ��ϐ�LANG�ɂ���Ēl�����ʂ���Aja_JP.UTF-8�ł����UTF-8���ݒ肳���D
�ELANG�ݒ肪File�N���X�Ŗ��O����������Ƃ��Ɏg����D

�ELANG���ϐ��́C�V�F���ł͎����I��ja_JP.UTF-8�ɐݒ肳���D
��jar�_�u���N���b�N�ł͓����Ȃ����C�R�}���h����N������Ɠ������ۂ͂��̂��߁D

�E�����̌��ʁC-Dsun.jnu.encoding=UTF-8 �́CFile�N���X�̃o�O�ɂ͂��܂���ʂ��Ȃ��D
�i�����̌��ʁC��LJVM�ϐ����w�肵�Ă��C�I�[�o�[���C�h�ł��Ȃ����ł���j

�����āF
�E���ׂẴA�v���N������LANG���ϐ���ݒ�
�� launchctl setenv LANG ja_JP.UTF-8
�EEclipse�͂��̃R�}���h����������C�����グ�����D

2013.10.14, matsuzawa
�i�ꎞ�I�ɐݒ� export LANG=ja_JP.UTF-8�j


