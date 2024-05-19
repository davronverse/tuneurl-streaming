package com.tuneurl.webrtc.util.service;

import com.tuneurl.webrtc.util.controller.dto.*;
import com.tuneurl.webrtc.util.exception.BaseServiceException;
import com.tuneurl.webrtc.util.model.AudioStreamDatabase;
import com.tuneurl.webrtc.util.util.fingerprint.FingerprintThreadCollector;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public interface AudioStreamService {

  public String getStreamAudioUrlPrefix(final String fileName);

  public String getSaveAudioFilesFolder(final String subDir);

  public Object[] fingerprintComparisons(
      List<FingerprintCompareResponse> selection,
      List<FingerprintResponse> frSelection,
      FingerprintCompareResponse fcr,
      FingerprintResponse fr);

  public EvaluateAudioStreamResponse evaluateAudioStream(
      AudioDataEntry audioDataEntry,
      EvaluateAudioStreamEntry evaluateAudioStreamEntry,
      String signature);

  public AudioStreamDataResponse runWebRtcScript(
      final String signature,
      boolean isExecute,
      final String command,
      final String url,
      final Long duration,
      AudioStreamDatabase pDB)
      throws BaseServiceException;

  public LinkedList<FingerprintThreadCollector> parallelFingerprintCollect(
          short[] data,
          Long fingerprintRate,
          StringBuffer dataFingerprintBuffer,
          int dataFingerprintBufferSize,
          long maxDuration,
          long counts,
          String rootDir,
          Random random);
}
