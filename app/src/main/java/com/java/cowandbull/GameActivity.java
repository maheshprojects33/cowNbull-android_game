package com.java.cowandbull;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    MediaPlayer soundClip;


    private EditText etGuessWord;

    private TextView tvQ, tvW, tvE, tvR, tvT, tvY, tvU, tvI, tvO, tvP;
    private TextView tvA, tvS, tvD, tvF, tvG, tvH, tvJ, tvK, tvL;
    private TextView tvZ, tvX, tvC, tvV, tvB, tvN, tvM;
    private ImageView tvBack, tvEnterBtn;


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager rvLayoutMgr;
    private ItemAdapterClass rvAdapter;

    private int random;


    private String guessedWords, secret;
    int cowCount, bullCount;
    private int sNo = 0;


    ArrayList<ItemListClass> itemList = new ArrayList<>();

    private ArrayList<String> secretWordList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        initViews();
        initKeyboard();
        initSecretWordList();
        keyboardClickAction();
        keyboardLongClickAction();
        random = new Random().nextInt(secretWordList.size());

       //TODO 1. Need to Fix Sound Issue after plyaer says no to play again then sound continues on main activity
        // backgroundMusic();



        tvEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                checkBlankEntry();


            }
        });

        initRecyclerViewAdapter();


    }

    // All Sounds Methods

    private void buttonClickSound() {
        soundClip = MediaPlayer.create(GameActivity.this, R.raw.mouseclick);
        soundClip.start();
    }

    private void backButtonClickSound() {
        soundClip = MediaPlayer.create(GameActivity.this, R.raw.watersplash);
        soundClip.start();
    }


    // TODO ERROR Background Music Method
    private void backgroundMusic() {
        soundClip = MediaPlayer.create(this, R.raw.game_music_1);
        soundClip.setLooping(true);
        soundClip.start();
    }

    private void errorSound(){
        soundClip = MediaPlayer.create(getApplicationContext(), R.raw.error1);
        soundClip.start();
    }

    private void errorVibration(){
        final Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    // Keyboard Click Action

    private void keyboardClickAction() {

            tvQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("Q");
                    tvQ.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvW.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("W");
                    tvW.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("E");
                    tvE.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("R");
                    tvR.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("T");
                    tvT.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("Y");
                    tvY.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvU.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("U");
                    tvU.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("I");
                    tvI.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvO.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("O");
                    tvO.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("P");
                    tvP.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });

            tvA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("A");
                    tvA.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("S");
                    tvS.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("D");
                    tvD.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("F");
                    tvF.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("G");
                    tvG.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("H");
                    tvH.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvJ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("J");
                    tvJ.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("K");
                    tvK.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("L");
                    tvL.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });

            tvZ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("Z");
                    tvZ.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("X");
                    tvX.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("C");
                    tvC.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("V");
                    tvV.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("B");
                    tvB.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("N");
                    tvN.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });
            tvM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etGuessWord.append("M");
                    tvM.setTextColor(Color.parseColor("#FFFFFF"));
                    buttonClickSound();
                }
            });

            tvBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    backButtonClickSound();
                    String bkspc = etGuessWord.getText().toString();
                    if (bkspc.length() > 1) {
                        bkspc = bkspc.substring(0, bkspc.length() - 1);
                        etGuessWord.setText(bkspc);
                    } else if (bkspc.length() <= 1) {
                        etGuessWord.setText("");
                    }
                    // etGuessWord.setText("");
                }
            });




    }

    private void keyboardLongClickAction() {

        tvQ.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvQ.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvW.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvW.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvE.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvE.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvR.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvR.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvT.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvT.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvY.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvY.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvU.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvU.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvI.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvI.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvO.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvO.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvP.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvP.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });

        tvA.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvA.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvS.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvS.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvD.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvD.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvF.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvF.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvG.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvG.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvH.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvH.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvJ.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvJ.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvK.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvK.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvL.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvL.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });

        tvZ.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvZ.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvX.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvX.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvC.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvV.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvV.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvB.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvB.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvN.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvN.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });
        tvM.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvM.setTextColor(Color.parseColor("#FF2D00"));
                errorVibration();
                return true;
            }
        });

    }

    // Initialization of Recycler View Adapter

    private void initRecyclerViewAdapter() {
        recyclerView = findViewById(R.id.recyclerView);
        rvLayoutMgr = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutMgr);

        rvAdapter = new ItemAdapterClass(this, itemList);
        recyclerView.setAdapter(rvAdapter);
    }

    // Secret Word List Array

    private void initSecretWordList() {
        secretWordList.add("game"); //0
        secretWordList.add("loVE"); //1
        secretWordList.add("MADE"); //2
        secretWordList.add("ROAD"); //3
        secretWordList.add("TAKE"); //4
        secretWordList.add("ROSE"); //5
        secretWordList.add("POST"); //6
        secretWordList.add("acid"); //7
        secretWordList.add("auto"); //8
        secretWordList.add("draw"); //9
        secretWordList.add("BUDS"); //10
        secretWordList.add("BACK"); //11
        secretWordList.add("BEAR"); //12
        secretWordList.add("BODY"); //13
        secretWordList.add("CHAT"); //14
        secretWordList.add("CLUB"); //15
        secretWordList.add("DARK"); //16
        secretWordList.add("FACE"); //17
        secretWordList.add("FISH"); //18
        secretWordList.add("GOLD"); //19
        secretWordList.add("HAND"); //20
        secretWordList.add("ABLE"); //20
        secretWordList.add("BANK"); //21
        secretWordList.add("BASE"); //22
        secretWordList.add("BATH"); //23
        secretWordList.add("BEAT"); //24
        secretWordList.add("BELT"); //25
        secretWordList.add("BEST"); //26
        secretWordList.add("BIRD"); //27
        secretWordList.add("BLOW"); //28
        secretWordList.add("BLUE"); //29
        secretWordList.add("BOAT"); //30
        secretWordList.add("BOND"); //31
        secretWordList.add("BONE"); //32
        secretWordList.add("BORN"); //33
        secretWordList.add("BOTH"); //34
        secretWordList.add("BOWL"); //35
        secretWordList.add("BULK"); //36
        secretWordList.add("BURN"); //37
        secretWordList.add("BUSH"); //38
        secretWordList.add("BUSY"); //39
        secretWordList.add("CALM"); //40
        secretWordList.add("CARD"); //41
        secretWordList.add("CAST"); //42
        secretWordList.add("CHIP"); //43
        secretWordList.add("CITY"); //44
        secretWordList.add("COAL"); //45
        secretWordList.add("COAT"); //46
        secretWordList.add("CODE"); //47
        secretWordList.add("COLD"); //48
        secretWordList.add("COME"); //49
        secretWordList.add("COPY"); //50
        secretWordList.add("COST"); //51
        secretWordList.add("CREW"); //52
        secretWordList.add("DATE"); //53
        secretWordList.add("DAWN"); //54
        secretWordList.add("DEAL"); //55
        secretWordList.add("DEAN"); //56
        secretWordList.add("DEAR"); //57
        secretWordList.add("DEBT"); //58
        secretWordList.add("DESK"); //59
        secretWordList.add("DIAL"); //60
        secretWordList.add("DIET"); //61
        secretWordList.add("DISC"); //62
        secretWordList.add("DOES"); //63
        secretWordList.add("DONE"); //64
        secretWordList.add("DOSE"); //65
        secretWordList.add("DOWN"); //66
        secretWordList.add("DROP"); //67
        secretWordList.add("DRUG"); //68
        secretWordList.add("DUAL"); //69
        secretWordList.add("DUST"); //70
        secretWordList.add("DUTY"); //71
        secretWordList.add("EAST"); //72
        secretWordList.add("EVIL"); //73
        secretWordList.add("EXIT"); //74
        secretWordList.add("FACT"); //75
        secretWordList.add("FAIL"); //76
        secretWordList.add("FAIR"); //77
        secretWordList.add("FARM"); //78
        secretWordList.add("FAST"); //79
        secretWordList.add("FATE"); //80
        secretWordList.add("FEAR"); //81
        secretWordList.add("FILM"); //82
        secretWordList.add("FLOW"); //83
        secretWordList.add("FOUR"); //84
        secretWordList.add("FUEL"); //85
        secretWordList.add("GATE"); //86
        secretWordList.add("GEAR"); //87
        secretWordList.add("GIFT"); //88
        secretWordList.add("GIRL"); //89
        secretWordList.add("GLAD"); //90
        secretWordList.add("GOAL"); //91
        secretWordList.add("GOLF"); //92
        secretWordList.add("HAIR"); //93
        secretWordList.add("HALF"); //94
        secretWordList.add("HARM"); //95
        secretWordList.add("HATE"); //96
        secretWordList.add("HEAT"); //97
        secretWordList.add("HIRE"); //98
        secretWordList.add("HOME"); //99
        secretWordList.add("HOPE"); //100
        secretWordList.add("HOST"); //101
        secretWordList.add("HOUR"); //102
        secretWordList.add("HUGE"); //103
        secretWordList.add("HUNT"); //104
        secretWordList.add("HURT"); //105
        secretWordList.add("IDEA"); //106
        secretWordList.add("INCH"); //107
        secretWordList.add("INTO"); //108
        secretWordList.add("IRON"); //109
        secretWordList.add("ITEM"); //110
        secretWordList.add("JACK"); //111
        secretWordList.add("KIND"); //112
        secretWordList.add("KING"); //113
        secretWordList.add("LADY"); //114
        secretWordList.add("LAID"); //115
        secretWordList.add("LAKE"); //116
        secretWordList.add("LANE"); //117
        secretWordList.add("LAST"); //118
        secretWordList.add("LEFT"); //119
        secretWordList.add("LIKE"); //120
        secretWordList.add("LINE"); //121
        secretWordList.add("LINK"); //122
        secretWordList.add("LIST"); //123
        secretWordList.add("LIVE"); //124
        secretWordList.add("LOAD"); //125
        secretWordList.add("LOAN"); //126
        secretWordList.add("LOCK"); //127
        secretWordList.add("LONG"); //128
        secretWordList.add("LORD"); //129
        secretWordList.add("LOSE"); //130
        secretWordList.add("LUCK"); //131
        secretWordList.add("MADE"); //132
        secretWordList.add("MAIL"); //133
        secretWordList.add("MARK"); //134
        secretWordList.add("MEAL"); //135
        secretWordList.add("MENU"); //136
        secretWordList.add("MILK"); //137
        secretWordList.add("MINE"); //138
        secretWordList.add("MODE"); //139
        secretWordList.add("MORE"); //140
        secretWordList.add("MOST"); //141
        secretWordList.add("MOVE"); //142
        secretWordList.add("MUCH"); //143
        secretWordList.add("MUST"); //144
        secretWordList.add("NAME"); //145
        secretWordList.add("NEWS"); //146
        secretWordList.add("NEXT"); //147
        secretWordList.add("NICE"); //148
        secretWordList.add("NICK"); //149
        secretWordList.add("NODE"); //150
        secretWordList.add("NOSE"); //151
        secretWordList.add("NOTE"); //152
        secretWordList.add("OMIT"); //153
        secretWordList.add("OPEN"); //154
        secretWordList.add("OVER"); //155
        secretWordList.add("PACK"); //156
        secretWordList.add("PALM"); //157
        secretWordList.add("PARK"); //158
        secretWordList.add("PART"); //159
        secretWordList.add("PAST"); //160
        secretWordList.add("PATH"); //161
        secretWordList.add("PICK"); //162
        secretWordList.add("PINK"); //163
        secretWordList.add("PLOT"); //164
        secretWordList.add("PLUG"); //165
        secretWordList.add("PLUS"); //166
        secretWordList.add("POLE"); //167
        secretWordList.add("PORT"); //168
        secretWordList.add("PURE"); //169
        secretWordList.add("PUSH"); //170
        secretWordList.add("RACE"); //171
        secretWordList.add("RAIL"); //172
        secretWordList.add("RAIN"); //173
        secretWordList.add("RANK"); //174
        secretWordList.add("RING"); //175
        secretWordList.add("RISK"); //176
        secretWordList.add("ROCK"); //177
        secretWordList.add("ROLE"); //178
        secretWordList.add("ROPE"); //179
        secretWordList.add("RUDE"); //180
        secretWordList.add("RULE"); //181
        secretWordList.add("RUSH"); //182
        secretWordList.add("SAFE"); //183
        secretWordList.add("SALT"); //184
        secretWordList.add("SAME"); //185
        secretWordList.add("SAND"); //186
        secretWordList.add("SAVE"); //187
        secretWordList.add("SEAT"); //188
        secretWordList.add("SELF"); //189
        secretWordList.add("SEND"); //190
        secretWordList.add("SENT"); //191
        secretWordList.add("SHIP"); //192
        secretWordList.add("SHOP"); //193
        secretWordList.add("SHOT"); //194
        secretWordList.add("SHOW"); //195
        secretWordList.add("SHUT"); //196
        secretWordList.add("SICK"); //197
        secretWordList.add("SIDE"); //198
        secretWordList.add("SIGN"); //199
        secretWordList.add("SITE"); //200
        secretWordList.add("SIZE"); //201
        secretWordList.add("SKEW"); //202
        secretWordList.add("SKIN"); //203
        secretWordList.add("SKIP"); //204
        secretWordList.add("SLAM"); //205
        secretWordList.add("SLAP"); //206
        secretWordList.add("SLOW"); //207
        secretWordList.add("SOFT"); //208
        secretWordList.add("SOIL"); //209
        secretWordList.add("SOLD"); //210
        secretWordList.add("SOLE"); //211
        secretWordList.add("SOME"); //212
        secretWordList.add("SOUL"); //213
        secretWordList.add("SOUP"); //214
        secretWordList.add("SPAM"); //215
        secretWordList.add("STIR"); //216
        secretWordList.add("SURE"); //217
        secretWordList.add("TALK"); //218
        secretWordList.add("TANK"); //219
        secretWordList.add("TAPE"); //220
        secretWordList.add("TASK"); //221
        secretWordList.add("TEAM"); //222
        secretWordList.add("TEAR"); //223
        secretWordList.add("TECH"); //224
        secretWordList.add("TERM"); //225
        secretWordList.add("TIME"); //226
        secretWordList.add("TOWN"); //227
        secretWordList.add("TRIM"); //228
        secretWordList.add("TRIP"); //229
        secretWordList.add("TUBE"); //230
        secretWordList.add("USED"); //231
        secretWordList.add("VINE"); //232
        secretWordList.add("VISA"); //233
        secretWordList.add("VOID"); //234
        secretWordList.add("VOLT"); //235
        secretWordList.add("VOTE"); //236
        secretWordList.add("WAIT"); //237
        secretWordList.add("WAKE"); //238
        secretWordList.add("WALK"); //239
        secretWordList.add("WANT"); //240
        secretWordList.add("WARD"); //241
        secretWordList.add("WARM"); //242
        secretWordList.add("WARP"); //243
        secretWordList.add("WASH"); //244
        secretWordList.add("WAVE"); //245
        secretWordList.add("WEAK"); //246
        secretWordList.add("WEAR"); //247
        secretWordList.add("WEST"); //248
        secretWordList.add("WIDE"); //249
        secretWordList.add("WIFE"); //250
        secretWordList.add("WILD"); //251
        secretWordList.add("WIND"); //252
        secretWordList.add("WINE"); //253
        secretWordList.add("WING"); //254
        secretWordList.add("WIRE"); //254
        secretWordList.add("WISE"); //255
        secretWordList.add("WISH"); //256
        secretWordList.add("WOLF"); //257
        secretWordList.add("WOMB"); //258
        secretWordList.add("WORD"); //259
        secretWordList.add("WORK"); //260
        secretWordList.add("WRAP"); //261
        secretWordList.add("YARD"); //262
        secretWordList.add("YAWN"); //263
        secretWordList.add("YEAR"); //264
        secretWordList.add("YELD"); //265
        secretWordList.add("YETI"); //266
        secretWordList.add("YOLK"); //267
        secretWordList.add("ZEAL"); //268
        secretWordList.add("ZERO"); //269
        secretWordList.add("ZINC"); //270
        secretWordList.add("ZONE"); //271
        secretWordList.add("WHEN"); //272
        secretWordList.add("WHAT"); //273
        secretWordList.add("ONLY"); //274
        secretWordList.add("ONCE"); //275
        secretWordList.add("ORAL"); //276
        secretWordList.add("PALE"); //277
        secretWordList.add("PINK"); //278
        secretWordList.add("RICH"); //279
        secretWordList.add("NEAR"); //280



    }

    // Condition to Check Blank Entry

    private void checkBlankEntry() {
        guessedWords = etGuessWord.getText().toString();
        if (TextUtils.isEmpty(guessedWords)) {
            etGuessWord.setError("Please Enter A Word");
            Toast.makeText(this, "Please Guess A Word", Toast.LENGTH_LONG).show();
            errorSound();
            errorVibration();
        } else if (guessedWords.length() != 4) {
            etGuessWord.setError("Word Should be of 4 Characters");
            Toast.makeText(this, "Word Should be of 4 Characters", Toast.LENGTH_LONG).show();
            errorSound();
            errorVibration();
        } else if(guessedWords.charAt(0) == guessedWords.charAt(1) || guessedWords.charAt(0) == guessedWords.charAt(2) || guessedWords.charAt(0) == guessedWords.charAt(3)
            || guessedWords.charAt(1) == guessedWords.charAt(2) || guessedWords.charAt(1) == guessedWords.charAt(3) || guessedWords.charAt(2) == guessedWords.charAt(3) ){
            etGuessWord.setError("Letters Should Not Repeat");
            errorSound();
            errorVibration();
            Toast.makeText(this, "Letters Should Not Repeat", Toast.LENGTH_LONG).show();
        }else {
            mainLogix();
        }
    }

    // Main Logic to check Game rules

    private void mainLogix() {

//        TODO Reveal Answer
//        Toast.makeText(this, "" + random, Toast.LENGTH_SHORT).show();


        secret = secretWordList.get(random).toUpperCase();
        guessedWords = etGuessWord.getText().toString().toUpperCase();

        bullCount = 0;
        for (int i = 0; i < 4; i++) {
            if (guessedWords.charAt(i) == secret.charAt(i)) {
                bullCount++;
            }
        }
        cowCount = 0;
        for (int i = 0; i < 4; i++) {
            if (guessedWords.charAt(i) == secret.charAt(0) && guessedWords.charAt(0) != secret.charAt(0)) {
                cowCount++;
            }
            if (guessedWords.charAt(i) == secret.charAt(1) && guessedWords.charAt(1) != secret.charAt(1)) {
                cowCount++;
            }
            if (guessedWords.charAt(i) == secret.charAt(2) && guessedWords.charAt(2) != secret.charAt(2)) {
                cowCount++;
            }
            if (guessedWords.charAt(i) == secret.charAt(3) && guessedWords.charAt(3) != secret.charAt(3)) {
                cowCount++;
            }
        }
        soundClip = MediaPlayer.create(getApplicationContext(), R.raw.rubberstamp);
        soundClip.start();
        if (guessedWords.equals(secret)) {
            soundClip = MediaPlayer.create(getApplicationContext(), R.raw.victory1);
            soundClip.start();


            winPlayAgainDialogBox();



            //Toast.makeText(this, "You Have Sucessfully Cracked The Word", Toast.LENGTH_SHORT).show();
        }


        int bull = bullCount;
        int cow = cowCount;
        sNo++;
        int lChance = 10;
        int hint = 4;
        int warning = lChance - 3;
        int lwarning = lChance - 1;

        if (String.valueOf(sNo).equals(String.valueOf(hint))) {
            Toast.makeText(this, "Long Press Letters To Mark", Toast.LENGTH_LONG).show();
            soundClip = MediaPlayer.create(getApplicationContext(), R.raw.notification1);
            soundClip.start();
        }
        if (String.valueOf(sNo).equals(String.valueOf(warning))) {
            Toast.makeText(this, "You Have Just 3 More Chances To Crack The Word", Toast.LENGTH_LONG).show();
            soundClip = MediaPlayer.create(getApplicationContext(), R.raw.notification1);
            soundClip.start();
        }
        if (String.valueOf(sNo).equals(String.valueOf(lwarning))) {
            Toast.makeText(this, "Last Chances, I Know You Can Crack", Toast.LENGTH_LONG).show();
            soundClip = MediaPlayer.create(getApplicationContext(), R.raw.notification1);
            soundClip.start();
        }

        if (!guessedWords.equals(secret) && String.valueOf(sNo).equals(String.valueOf(lChance))) {
            lostPlayAgainDialogBox();
        }


        itemList.add(new ItemListClass(guessedWords, String.valueOf(cow), String.valueOf(bull), String.valueOf(sNo)));
        rvAdapter.notifyDataSetChanged();

        etGuessWord.setText("");

    }

    // Win & Play Again Alert Dialog Box

    private void winPlayAgainDialogBox() {



        AlertDialog.Builder playAgainDialog = new AlertDialog.Builder(this);
        playAgainDialog.setTitle("Congratulation!! You Have Sucessfully Cracked The Word.")
                .setMessage("\n Do You Want To Crack More Words?")
                .setCancelable(false)
                .setPositiveButton("I Love To Crack", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(GameActivity.this, GameActivity.class));
                    }
                })
                .setNegativeButton("Will Crack Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(GameActivity.this, MainActivity.class));

                        //TODO 2. Need to stop backgroud music after negative button clicked (Win & Play Again)
                       // soundClip.stop();
                        finish();
                    }
                }).show();

    }

    // Lost & Play Again Alert Dialog Box

    private void lostPlayAgainDialogBox() {


        AlertDialog.Builder lostPlayAgainDialog = new AlertDialog.Builder(this);
        lostPlayAgainDialog.setTitle("You Didn't Crack This Word On Time")
                .setMessage("\t\t\t\t\t\t\t" + "The Secret Word is:" + "\n\t\t\t\t\t\t\t\t\t\t\t" + secret + "\n\n Do You Want To Try Again?")
                .setCancelable(false)
                .setPositiveButton("I'll Do It On Time Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(GameActivity.this, GameActivity.class));
                    }
                })
                .setNegativeButton("I'm Tired For Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(GameActivity.this, MainActivity.class));

                        //TODO 3. Need to stop Background Music after Negative button clicked (Lost & Play Again)
                        //soundClip.stop();
                        finish();
                    }
                }).show();


    }

    // Soft Back Button Pressed Alert Dialog Box

    private void backPressDialogBox() {
        AlertDialog.Builder backPress = new AlertDialog.Builder(this);
        backPress.setTitle("Do You Really Want To Go Without Cracking Word")
                .setMessage("You Can Do It Lets Go!!!")
                .setCancelable(false)
                .setPositiveButton("Ok Lets Go", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //startActivity(new Intent(GameActivity.this, GameActivity.class));
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("I'll Come Back Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(GameActivity.this, MainActivity.class));
                        finishAffinity();
                    }
                })
                .show();

    }

    // Initilaization of All Views

    private void initViews() {
        etGuessWord = findViewById(R.id.etGuess);


        // recyclerView = findViewById(R.id.recyclerView);

        tvEnterBtn = findViewById(R.id.tvEnter);


    }

    // Initialization of Keyboard Keys

    private void initKeyboard() {
        tvQ = findViewById(R.id.tvQ);
        tvW = findViewById(R.id.tvW);
        tvE = findViewById(R.id.tvE);
        tvR = findViewById(R.id.tvR);
        tvT = findViewById(R.id.tvT);
        tvY = findViewById(R.id.tvY);
        tvU = findViewById(R.id.tvU);
        tvI = findViewById(R.id.tvI);
        tvO = findViewById(R.id.tvO);
        tvP = findViewById(R.id.tvP);

        tvA = findViewById(R.id.tvA);
        tvS = findViewById(R.id.tvS);
        tvD = findViewById(R.id.tvD);
        tvF = findViewById(R.id.tvF);
        tvG = findViewById(R.id.tvG);
        tvH = findViewById(R.id.tvH);
        tvJ = findViewById(R.id.tvJ);
        tvK = findViewById(R.id.tvK);
        tvL = findViewById(R.id.tvL);

        tvZ = findViewById(R.id.tvZ);
        tvX = findViewById(R.id.tvX);
        tvC = findViewById(R.id.tvC);
        tvV = findViewById(R.id.tvV);
        tvB = findViewById(R.id.tvB);
        tvN = findViewById(R.id.tvN);
        tvM = findViewById(R.id.tvM);

        tvBack = findViewById(R.id.tvBack);

    }



    // OverRide method on physical Back Button Press

    @Override
    public void onBackPressed() {
        backPressDialogBox();

        // TODO 4. Need to stop Background Music after Backbutton Press
//        soundClip.stop();
    }
}