package org.acme.conference.vote;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeVoteResourceIT extends VoteResourceTest {

    // Execute the same tests but in native mode.
}